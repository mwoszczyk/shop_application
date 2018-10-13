package pl.mwosz.Shop_App.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.mwosz.Shop_App.Domain.Product;
import pl.mwosz.Shop_App.Service.CategoryService;
import pl.mwosz.Shop_App.Service.ProductService;

import java.util.Optional;

@Controller
public class ProductController {

    private ProductService productService;
    private CategoryService categoryService;
    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping("/product/all")
    public String allProducts(Model model) {

        log.info("allProducts() from ProductController....");

        model.addAttribute("allProducts", productService.allProducts());
        model.addAttribute("categories", categoryService.allCategories());

        return "product/product-all";
    }

    @GetMapping("/product/add")
    public String addProduct(Model model) {

        log.info("addProduct() from product controller....");
        model.addAttribute("product", new Product());
        model.addAttribute("fromCategories", categoryService.allCategories());  // nie powinienm listy "name" przekazywac? wyswietla teraz zawsze "category"
        model.addAttribute("title", "New");
        model.addAttribute("paragraph", "New");

        return "product/product-add-edit";
    }

    @PostMapping("/product/save")
    public String productSaving(@ModelAttribute Product product, @RequestParam(name = "productSaveDecision") String pushedButton){

        log.info("productSave() from ProductController...");

        if ("Save".equalsIgnoreCase(pushedButton)) {
            log.info("Confirming save in ProductController....");
            productService.saveProduct(product);
        }

        return "redirect:/product/all";

        /*switch (pushedButton) {
            case "Save":
                log.info("Confirming save in ProductController....");
                productService.saveProduct(product);
                return "redirect:/product/all";
                default:
                    return "redirect:/product/all";
        }*/
    }

    @GetMapping("/product/edit/{id}")
    public String productEdit(@PathVariable("id") long id, Model model) {
        log.info("productEdit() from ProducrController....");

        Optional<Product> productExistanceResult = productService.findProductById(id);
        productExistanceResult.ifPresent(product -> model.addAttribute("product", product));     // skad wie ze chodzi o product??
        model.addAttribute("title", "Edit");
        model.addAttribute("paragraph", "Edit");
        model.addAttribute("fromCategories", categoryService.allCategories());

        return "product/product-add-edit";
    }

    @GetMapping("/product/delete/confirmation/{id}")
    public String deleteProductConfirmation(@PathVariable("id") long id, Model model) {
        log.info("deleteProductConfirmation() from ProductController....");
        model.addAttribute("productId", id);
        return "product/product-delete-confirmation";
    }

    @GetMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable("id") long id) {
        log.info(String.format("deleteProduct() from ProductController.... Product ID: [%s]", id));
        productService.deleteProductById(id);
        return "redirect:/product/all";
    }

}
