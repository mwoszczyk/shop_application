package pl.mwosz.Shop_App.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.mwosz.Shop_App.Service.LoginService;

@Controller
public class LoginController {

    private LoginService loginService;
    private Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping(value = "/login")
    public String loginPage(@RequestParam String login, @RequestParam String password) {

        log.info(String.format("login user [%s]", login));
        loginService.logIn(login,password);

        return "/templates/login/loginPage.html";
    }
}
