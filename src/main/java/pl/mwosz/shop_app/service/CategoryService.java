package pl.mwosz.shop_app.service;

import pl.mwosz.shop_app.domain.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Category> allCategories();
    boolean saveCategory(Category category);
    Optional<Category> findCategoryById(Long id);
    void deleteCategoryById(Long id);
}
