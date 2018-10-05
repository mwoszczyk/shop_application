package pl.mwosz.Shop_App.Service.Implementations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mwosz.Shop_App.Dao.ProductDao;
import pl.mwosz.Shop_App.Domain.Product;
import pl.mwosz.Shop_App.Service.ProductService;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
    private ProductDao productDao;

    @Autowired
    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> allProducts() {
        log.info("allProducts() from ProductServiceImpl....");
        //todo: UNSAFE-type
        return (List<Product>) productDao.findAll();
    }

    @Override
    public void addProduct(Product product, Integer quantity) {

    }

    @Override
    public void deleteProduct(Product product) {
        productDao.delete(product);
    }

    @Override
    public boolean saveProduct(Product product) {
        log.info("saveProduct() from ProducrServiceImpl....");
        Product saveResult = productDao.save(product);
        return null != saveResult.getId();
    }

    @Override
    public Optional<Product> findProductById(Long id) {
        return productDao.findById(id);
    }
}
