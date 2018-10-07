package pl.mwosz.Shop_App.Service.Implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mwosz.Shop_App.Dao.CategoryDao;
import pl.mwosz.Shop_App.Domain.Category;
import pl.mwosz.Shop_App.Service.CategoryService;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryDao categoryDao;

    @Autowired
    public CategoryServiceImpl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public List<Category> allCategories() {
        return (List<Category>) categoryDao.findAll();
    }

    @Override
    public boolean saveCategory(Category category) {
        Category saveResult = categoryDao.save(category);
        return null != saveResult.getId();
    }

    @Override
    public Optional<Category> findCategoryById(Long id) {
        return categoryDao.findById(id);
    }

    @Override
    public void deleteCategoryById(Long id) {
        categoryDao.deleteById(id);
    }
}
