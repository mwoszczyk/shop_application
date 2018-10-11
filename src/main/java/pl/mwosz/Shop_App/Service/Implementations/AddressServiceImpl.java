package pl.mwosz.Shop_App.Service.Implementations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mwosz.Shop_App.Dao.AddressDao;
import pl.mwosz.Shop_App.Domain.Address;
import pl.mwosz.Shop_App.Service.AddressService;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    private static final Logger log = LoggerFactory.getLogger(AddressServiceImpl.class);
    private AddressDao addressDao;

    @Autowired
    public AddressServiceImpl(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    @Override
    public List<Address> allAddress() {
        log.info("[AddressServiceImpl] - Listing all addresses....");
        return (List<Address>) addressDao.findAll();
    }

    @Override
    public boolean saveAddress(Address address) {
        log.info("[AddressServiceImpl] - Saving address....");
        Address addressSaveResult = addressDao.save(address);
        return null != addressSaveResult.getId();
    }

    @Override
    public Optional<Address> findAddress(Long id) {
        log.info(String.format("[AddressServiceImpl] - Searching for address by id: [%s]" , id));
        return addressDao.findById(id);
    }

    @Override
    public void deleteAddressById(Long id) {
        log.info(String.format("[AddressServiceImpl] - Deleting address by id: [%s]", id));
        addressDao.deleteById(id);
    }
}
