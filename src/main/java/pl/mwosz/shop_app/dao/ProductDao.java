package pl.mwosz.shop_app.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.mwosz.shop_app.domain.Product;

@Repository
public interface ProductDao extends CrudRepository<Product, Long> {
}
