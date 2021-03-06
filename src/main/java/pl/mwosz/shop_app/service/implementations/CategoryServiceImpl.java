package pl.mwosz.shop_app.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mwosz.shop_app.dao.CategoryDao;
import pl.mwosz.shop_app.domain.Category;
import pl.mwosz.shop_app.service.CategoryService;

import java.util.Collections;
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
        List<Category> sortedList = (List<Category>) categoryDao.findAll();
        Collections.sort(sortedList, (o1, o2) -> o1.getName().compareTo(o2.getName()));
        return sortedList;
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
