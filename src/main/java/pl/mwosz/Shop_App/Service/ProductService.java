package pl.mwosz.Shop_App.Service;

import pl.mwosz.Shop_App.Domain.Product;

import java.util.List;

public interface ProductService {

    List<Product> allProducts();
    void addProduct(Product product, Integer quantity);
    void deleteProduct(Product product);
}