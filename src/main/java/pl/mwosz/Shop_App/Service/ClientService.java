package pl.mwosz.Shop_App.Service;

import pl.mwosz.Shop_App.Domain.Client;

import java.util.List;

public interface ClientService {

    List<Client> clientList();
    boolean saveClient(Client client);
}
