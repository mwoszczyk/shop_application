package pl.mwosz.Shop_App.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.mwosz.Shop_App.Service.UserService;

@Controller
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/all")
    public String allUsers(Model model) {
        log.info("[UserController] - Listing all users....");

        model.addAttribute("users", userService.allUsers());

        return "user/user-all";
    }
}
