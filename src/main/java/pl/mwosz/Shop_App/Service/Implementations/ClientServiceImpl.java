package pl.mwosz.Shop_App.Service.Implementations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mwosz.Shop_App.Dao.ClientDao;
import pl.mwosz.Shop_App.Domain.Client;
import pl.mwosz.Shop_App.Service.ClientService;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientDao clientDao;
    private static final Logger log = LoggerFactory.getLogger(ClientServiceImpl.class);

    @Autowired
    public ClientServiceImpl(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    @Override
    public List<Client> clientList() {
        log.info("[ClientServiceImpl] - Listing all clients....");
        return (List<Client>) clientDao.findAll();
    }

    @Override
    public boolean saveClient(Client client) {
        log.info("[ClientServiceImpl] - Save client....");
        clientDao.save(client);
        return null != client.getId();
    }
}
