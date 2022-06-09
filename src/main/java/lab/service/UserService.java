package lab.service;

import lab.entity.UserEntity;
import lab.entity.dto.UserLoginDTO;
import lab.repositories.UserRepository;
import lab.user.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private UserRepository userRepository;
    private CurrentUser currentUser;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, CurrentUser currentUser, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean login(UserLoginDTO loginDTO){
        Optional<UserEntity> optionalUser = userRepository.findByEmail(loginDTO.getUsername());

        if (optionalUser.isEmpty()){
            LOGGER.debug("User with name [{}] not found", loginDTO.getUsername());
            return false;
        }

        var rawPassword = loginDTO.getPassword();
        var encodedPassword = optionalUser.get().getPassword();

        boolean success = passwordEncoder.matches(rawPassword, encodedPassword);

        if (success){
            login(optionalUser.get());
        } else {
            logout();
        }
        return success;
    }

    private void login(UserEntity user){
        currentUser.setLoggedIn(true);
        currentUser.setName(user.getFirstName() + " " + user.getLastName());
    }

    public void logout(){
        currentUser.clear();

    }
}
