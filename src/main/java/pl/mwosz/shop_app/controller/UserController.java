package pl.mwosz.shop_app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.mwosz.shop_app.domain.User;
import pl.mwosz.shop_app.service.UserService;

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

    @GetMapping("/user/add")
    public String addUser(Model model) {
        log.info("[UserController] - Adding new User");
        model.addAttribute("addEditUser", new User());
        model.addAttribute("title", "New");
        model.addAttribute("paragraph", "New");

        return "user/user-add-edit";
    }

    @PostMapping("/user/save")
    public String saveUser(@ModelAttribute User user,
                           @RequestParam(name = "decision") String pushedButton) {
        log.info("[UserController] - Saving user");

        if ("Save".equalsIgnoreCase(pushedButton)) {
            log.info("[UserController] - Save confirmation...");
            userService.saveUser(user);
        }
        return "redirect:/user/all";
    }


}
