package pl.mwosz.Shop_App.Service.Implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mwosz.Shop_App.Dao.ClientDao;
import pl.mwosz.Shop_App.Service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientDao clientDao;

    @Autowired
    public ClientServiceImpl(ClientDao clientDao) {
        this.clientDao = clientDao;
    }
}
