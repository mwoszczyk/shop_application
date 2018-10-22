package pl.mwosz.shop_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import pl.mwosz.shop_app.domain.Product;
import pl.mwosz.shop_app.domain.ShoppingCart;
import pl.mwosz.shop_app.service.ProductService;

import java.util.ArrayList;
import java.util.Optional;

@Controller
@SessionAttributes("basket")
public class BasketController {

    private ProductService productService;

    @Autowired
    public BasketController(ProductService productService) {
        this.productService = productService;
    }

    @ModelAttribute("basket")
    public ShoppingCart getNewShoppingCart() {
        return new ShoppingCart(new ArrayList<>());
    }

    @GetMapping("/basket-content")
    public String showBusketContent(Model model,
                                    @ModelAttribute("basket") ShoppingCart cart) {
        model.addAttribute("data", cart);
        return "basket/basket-data";
    }

    @GetMapping("/basket/add/{id}")
    public RedirectView create(@PathVariable("id") long id,
                               @ModelAttribute("basket") ShoppingCart shoppingCart,
                               RedirectAttributes attributes) { // bezpieczny jak chodzi o sesje i redirect lokalizacji

        Optional<Product> productExistanceResult = productService.findProductById(id);
        productExistanceResult.ifPresent(product -> shoppingCart.addProductToCart(product));
        attributes.addFlashAttribute("basket", shoppingCart);

        return new RedirectView("/basket-content");
    }
}
