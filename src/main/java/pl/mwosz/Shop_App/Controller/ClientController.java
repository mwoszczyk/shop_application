package pl.mwosz.Shop_App.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.mwosz.Shop_App.Domain.Client;
import pl.mwosz.Shop_App.Service.ClientService;

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

        model.addAttribute("newClient", new Client());
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
                log.info(String.format("[ClientController] - Saving client id: [%s]", client.getId()));
                clientService.saveClient(client);
                log.info(String.format("[ClientController] - Saved client id: [%s]" , client.getId()));
                return "redirect:/client/all";
                default:
                    log.info(String.format("[ClientController] - Save canceled - Client id: [%s]", client.getId()));
                    return "redirect:/client/all";
        }
    }


}
