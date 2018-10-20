package pl.mwosz.shop_app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    private static final Logger log = LoggerFactory.getLogger(WebController.class);

    @GetMapping(value = {"/", "/main", "/home"})
    public String mainWWW() {
        log.info("connecting to main page from [web controller]....");
        return "mainWWW";
    }
}
