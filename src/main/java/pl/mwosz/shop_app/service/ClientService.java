package pl.mwosz.shop_app.service;

import pl.mwosz.shop_app.domain.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    List<Client> clientList();
    boolean saveClient(Client client);
    Optional<Client> checkingCLientExistance(Long id);
    void deleteClientById(Long id);
}
