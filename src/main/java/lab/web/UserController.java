package lab.web;

import lab.entity.dto.UserLoginDTO;
import lab.entity.dto.UserRegisterDTO;
import lab.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    // LOGIN / LOGOUT
    @GetMapping("/login")
    public String login() {
        return "auth-login";
    }

    @GetMapping("/logout")
        public String logout() {
        userService.logout();
        return "redirect:/";

    }

    @PostMapping("/login")
    public String login(UserLoginDTO userLoginDTO) {
        userService.login(userLoginDTO);
        System.out.println("User is logged: " + userService.login(userLoginDTO));
        return "redirect:/";
    }

    // REGISTRATION
    @GetMapping("/register")
    public String register(){
        return "auth-register";
    }

    @PostMapping("/register")
    public String register(@Valid UserRegisterDTO userRegisterDTO) {
        userService.registerAndLogin(userRegisterDTO);
        return "redirect:/";
    }
}
