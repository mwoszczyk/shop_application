package pl.mwosz.Shop_App.Service;

import pl.mwosz.Shop_App.Domain.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Category> allCategories();
    boolean saveCategory(Category category);
    Optional<Category> findCategoryById(Long id);
    void deleteCategoryById(Long id);
}
