package pl.mwosz.Shop_App.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.mwosz.Shop_App.Domain.Category;
import pl.mwosz.Shop_App.Service.CategoryService;

import java.util.Optional;

@Controller
public class CategoryController {

    private static final Logger log = LoggerFactory.getLogger(CategoryController.class);
    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/category/all")
    public String allCategories(Model model) {
        log.info("allCategories() from CategoryController....");
        model.addAttribute("allCategories", categoryService.allCategories());
        return "category/category-all";
    }

    @GetMapping("/category/add")
    public String addCategory(Model model) {
        log.info("addCategory() from CategoryController....");
        model.addAttribute("category", new Category());
        return "/category/category-add";
    }

    @PostMapping("/category/save")
    public String saveCategory(@ModelAttribute Category category, @RequestParam(name = "decision") String decisionMade) {
        log.info("saveCategory() from CategoryController....");

        if ("Save".equalsIgnoreCase(decisionMade)) {
            log.info("Admin confirmed saveing....");
            categoryService.saveCategory(category);
            log.info(String.format("Category [%s] saved...." , category.getName()));
        }

        return "redirect:/category/all";
    }

    @GetMapping("/category/edit/{id}")
    public String categoryEdit(@PathVariable(name = "id") long id, Model model) {
        log.info(String.format("Editing category id: [%s] from CategoryController....", id));

        Optional<Category> categoryExistanceResult = categoryService.findCategoryById(id);
        categoryExistanceResult.ifPresent(category -> model.addAttribute("categoryEdit", category));

        return "category/category-edit";
    }

    @GetMapping("/category/delete/choice/{id}")
    public String deleteCategoryChoice(@PathVariable(name = "id") long id, Model model) {
        log.info(String.format("deleteCategoryConfirmation() from CategoryController.... Category id: [%s]", id));
        model.addAttribute("categoryId", id);
        return "category/category-confirmation";
    }

    @GetMapping("/category/delete/{id}")
    public String deleteCategory(@PathVariable("id") long id) {
        log.info(String.format("Category id: [%s] deleting from CategoryController....", id));
        categoryService.deleteCategoryById(id);
        return "redirect:/category/all";
    }

}
