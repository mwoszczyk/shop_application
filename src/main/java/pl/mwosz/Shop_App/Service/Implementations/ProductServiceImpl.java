package pl.mwosz.Shop_App.Service.Implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mwosz.Shop_App.Dao.ProductDao;
import pl.mwosz.Shop_App.Domain.Product;
import pl.mwosz.Shop_App.Service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductDao productDao;

    @Autowired
    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> allProducts() {
        //todo: UNSAFE-type
        return (List<Product>) productDao.findAll();
    }

    @Override
    public void addProduct(Product product, Integer quantity) {

    }

    @Override
    public void deleteProduct(Product product) {

    }
}
