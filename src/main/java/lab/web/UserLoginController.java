package lab.web;

import lab.entity.dto.UserLoginDTO;
import lab.entity.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserLoginController {

    private UserService userService;

    public UserLoginController(UserService userService) {
        this.userService = userService;
    }

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
}
