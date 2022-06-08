package lab.entity.service;

import lab.entity.UserEntity;
import lab.entity.dto.UserLoginDTO;
import lab.entity.repositories.UserRepository;
import lab.entity.user.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private UserRepository userRepository;
    private CurrentUser currentUser;

    public UserService(UserRepository userRepository, CurrentUser currentUser){
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }

    public boolean login(UserLoginDTO loginDTO){
        Optional<UserEntity> optionalUser = userRepository.findByEmail(loginDTO.getUsername());

        if (optionalUser.isEmpty()){
            LOGGER.debug("User with name [{}] not found", loginDTO.getUsername());
            return false;
        }

        boolean success = optionalUser.get().getPassword().equals(loginDTO.getPassword());

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
