package pl.mwosz.Shop_App.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.mwosz.Shop_App.Dao.LoginDao;
import pl.mwosz.Shop_App.Service.ClientService;
import pl.mwosz.Shop_App.Service.OrderService;
import pl.mwosz.Shop_App.Service.ProductService;

@Controller
public class WebController {

    private static final Logger log = LoggerFactory.getLogger(WebController.class);

    @GetMapping(value = {"/", "/main"})
    public String mainWWW() {
        log.info("connecting to main page from [web controller]....");
        return "templates/mainWWW.html";        // dlaczego tylko taki zapis mnie przenosi? .html i templates?
    }
}
