package pl.mwosz.shop_app.service;

import pl.mwosz.shop_app.domain.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService {

    List<Address> allAddress();
    boolean saveAddress(Address address);
    Optional<Address> findAddress(Long id);
    void deleteAddressById(Long id);
}
