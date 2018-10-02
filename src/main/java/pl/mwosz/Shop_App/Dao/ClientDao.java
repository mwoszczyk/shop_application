package pl.mwosz.Shop_App.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.mwosz.Shop_App.Domain.Client;

@Repository
public interface ClientDao extends CrudRepository<Client, Long> {
}
