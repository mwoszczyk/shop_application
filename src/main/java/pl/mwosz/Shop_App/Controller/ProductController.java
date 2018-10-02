package pl.mwosz.Shop_App.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.mwosz.Shop_App.Domain.Product;
import pl.mwosz.Shop_App.Service.ProductService;

@Controller
public class ProductController {

    private ProductService productService;
    private static final Logger log = LoggerFactory.getLogger(ProductController.class);
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product/all")
    public String allProducts(Model model) {

        log.info("allProducts() from ProductController....");

        model.addAttribute("allProducts", productService.allProducts());

        return "templates/product/product-all.html";    // czemu tylko tak mnie przenosi? .html musi byc
    }

    @GetMapping("/product/add")
    public String addProduct(Model model) {

        log.info("addProduct() from product controller....");
        model.addAttribute("newProduct", new Product());

        return "templates/product/product-add";
    }



}
