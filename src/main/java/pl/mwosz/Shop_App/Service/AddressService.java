package pl.mwosz.Shop_App.Service;

import pl.mwosz.Shop_App.Domain.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService {

    List<Address> allAddress();
    boolean saveAddress(Address address);
    Optional<Address> findAddress(Long id);
    void deleteAddressById(Long id);
}
