package pl.mwosz.Shop_App.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.mwosz.Shop_App.Domain.Address;

@Repository
public interface AddressDao extends CrudRepository<Address, Long> {
}
