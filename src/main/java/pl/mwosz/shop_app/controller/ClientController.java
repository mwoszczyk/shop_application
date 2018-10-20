package pl.mwosz.shop_app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.mwosz.shop_app.domain.Client;
import pl.mwosz.shop_app.service.ClientService;

import java.util.Optional;

@Controller
public class ClientController {

    private ClientService clientService;
    private static final Logger log = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/client/all")
    public String allClients(Model model) {
        log.info("[ClientController] - Listing all clients....");
        model.addAttribute("clients", clientService.clientList());
        return "client/client-all";
    }

    @GetMapping("/client/add")
    public String addClient(Model model) {
        log.info("[ClientController] - Adding new client");

        model.addAttribute("addEditClient", new Client());
        model.addAttribute("title", "New");
        model.addAttribute("paragraph", "New");

        return "client/client-add-edit";
    }

    @PostMapping("/client/save")
    public String saveNewClient(@ModelAttribute Client client,
                                @RequestParam(name = "decision") String decision) {
        log.info("[ClientController] - Save client....");

        switch (decision) {
            case "SAVE":
                log.info(String.format("[ClientController] - Saving client id: [%s]", client.getId()));     // w dziwnej kolejnosci logi sie wyswietlaja, pozniej wyswietlany jest log "Save client...."
                clientService.saveClient(client);
                log.info(String.format("[ClientController] - Saved client id: [%s]" , client.getId()));
                return "redirect:/client/all";
                default:
                    log.info(String.format("[ClientController] - Save canceled - Client id: [%s]", client.getId()));
                    return "redirect:/client/all";
        }
    }

    @GetMapping("/client/edit/{id}")
    public String editClient(@PathVariable("id") long id, Model model) {
        log.info(String.format("[ClientController] - Editing client by id: [%s]", id));

        Optional<Client> clientExistanceResult = clientService.checkingCLientExistance(id);
        clientExistanceResult.ifPresent(client -> model.addAttribute("addEditClient", client)); // skad wiem ze ten "client ->" to ten o ktorego mi chodzi? powtorzenie z lambd
        model.addAttribute("title", "Edit");
        model.addAttribute("paragraph", "Edit");

        return "client/client-add-edit";
    }

    @GetMapping("/client/delete/choice/{id}")
    public String clientDeleteChoice(@PathVariable("id") long id, Model model) {
        log.info(String.format("[ClientController] - Confirming delete of clinet by id: [%s]", id));

        model.addAttribute("cId", id);

        return "client/client-delete-choice";
    }

    @GetMapping("/client/delete/{id}")
    public String clientDelete(@PathVariable("id") long id){
        log.info(String.format("[ClientController] - Client id: [%s]" , id));
        clientService.deleteClientById(id);
        return "redirect:/client/all";
    }
}
