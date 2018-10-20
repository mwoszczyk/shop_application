package pl.mwosz.shop_app.service;

import pl.mwosz.shop_app.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> allProducts();
    void deleteProductById(Long id);
    boolean saveProduct(Product product);
    Optional<Product> findProductById(Long id);
}
