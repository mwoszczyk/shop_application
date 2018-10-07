package pl.mwosz.Shop_App.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.mwosz.Shop_App.Domain.PaymentMethod;

@Repository
public interface PaymentMethodDao extends CrudRepository<PaymentMethod, Long> {
}
