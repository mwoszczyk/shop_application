package pl.mwosz.shop_app.service.implementations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mwosz.shop_app.dao.ClientDao;
import pl.mwosz.shop_app.domain.Client;
import pl.mwosz.shop_app.service.ClientService;

import java.util.List;
import java.util.Optional;

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
        return null != client.getId();          // <----------------- !!!???
    }

    @Override
    public Optional<Client> checkingCLientExistance(Long id) {
        return clientDao.findById(id);
    }

    @Override
    public void deleteClientById(Long id) {
        clientDao.deleteById(id);
    }
}
