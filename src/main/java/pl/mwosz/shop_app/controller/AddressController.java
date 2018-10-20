package pl.mwosz.shop_app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.mwosz.shop_app.domain.Address;
import pl.mwosz.shop_app.service.AddressService;

import java.util.Optional;

@Controller
public class AddressController {

    private static final Logger log = LoggerFactory.getLogger(AddressController.class);
    private AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/address/all")
    public String allAddress(Model model) {
        log.info("[AddressController] - Listing all Addresses....");
        model.addAttribute("addressList", addressService.allAddress());
        return "address/address-all";
    }

    @GetMapping("/address/add")
    public String addAddress(Model model) {
        log.info("[AddressController] - Adding new address....");

        model.addAttribute("title", "New");
        model.addAttribute("head", "New");
        model.addAttribute("addEditAddress", new Address());

        return "address/address-add-edit";
    }

    @PostMapping("/address/save")
    public String saveAddress(@ModelAttribute Address address,
                              @RequestParam(name = "decision") String pushedButton) {
        log.info(String.format("[AddressController] - Waiting for save decision.... Address id: [%s]", address.getId()));

        switch (pushedButton) {
            case "Save":
                log.info(String.format("[AddressController] - Confirmation for save address id: [%s]", address.getId()));
                addressService.saveAddress(address);
                return "redirect:/address/all";
                default:
                    log.info("[AddressController] - Save canceled becouse of HOOOMAN....");
                    log.info("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
                    return "redirect:/address/all";
        }
    }

    @GetMapping("/address/edit/{id}")
    public String editAddress(Model model, @PathVariable("id") long id) {
        log.info("[AddressController] - Editing address....");

        Optional<Address> addressSearchResult = addressService.findAddress(id);
        addressSearchResult.ifPresent(address -> model.addAttribute("addEditAddress", address));
        model.addAttribute("title", "Edit");
        model.addAttribute("head", "Edit");

        return "address/address-add-edit";
    }

    @GetMapping("/address/delete/choice/{id}")
    public String addressDeleteChoice(@PathVariable("id") long id, Model model) {
        log.info(String.format("[AddressController] - Confirming delete decision of address id: [%s]" , id));
        model.addAttribute("addressId", id);
        return "address/address-delete-choice";
    }

    @GetMapping("/address/delete/{id}")
    public String deletingAddressById(@PathVariable("id") long id){
        log.info(String.format("[AddressController] - Deleting address by id: [%s]", id));
        addressService.deleteAddressById(id);
        return "redirect:/address/all";
    }
}
