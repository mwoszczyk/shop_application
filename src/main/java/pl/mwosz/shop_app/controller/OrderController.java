package pl.mwosz.shop_app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.mwosz.shop_app.domain.Address;
import pl.mwosz.shop_app.domain.Client;
import pl.mwosz.shop_app.domain.Order;
import pl.mwosz.shop_app.domain.ShoppingCart;
import pl.mwosz.shop_app.service.*;

import java.time.LocalDateTime;

@Controller
//@SessionAttributes("basket")
public class OrderController {

    private static final Logger log = LoggerFactory.getLogger(OrderController.class);
    private OrderService orderService;
    private ProductService productService;
    private CategoryService categoryService;
    private PaymentMethodService paymentMethodService;
    private ClientService clientService;
    private AddressService addressService;

    @Autowired
    public OrderController(OrderService orderService, ProductService productService,
                           CategoryService categoryService, PaymentMethodService paymentMethodService,
                           ClientService clientService, AddressService addressService) {
        this.orderService = orderService;
        this.productService = productService;
        this.categoryService = categoryService;
        this.paymentMethodService = paymentMethodService;
        this.clientService = clientService;
        this.addressService = addressService;
    }

    @GetMapping("/product/list")
    public String productList(Model model) {

        model.addAttribute("products", productService.allProducts());
        /*model.addAttribute("category", categoryService.);  cos tu powinienem dodac?*/

        return "basket/products-list";
    }

    @GetMapping("/order/add")
    public String creatingOrder(Model model, @ModelAttribute("basket") ShoppingCart shoppingCart) {
        log.info("TU");
        model.addAttribute("order", new Order());
        model.addAttribute("payMeth", paymentMethodService.allPaymentMethods());
        return "basket/order-final";
    }

    @PostMapping("/order/save")
    public String savingOrder(@ModelAttribute Order order,
                              @RequestParam(name = "client.name") String clientName,
                              @RequestParam(name = "client.surname") String clientSurname,
                              @RequestParam(name = "client.clintAddress.city") String city,
                              @RequestParam(name = "client.clintAddress.postalCode") Integer postalCode,
                              @RequestParam(name = "client.clintAddress.street") String street,
                              @RequestParam(name = "client.clintAddress.streetNumber") String streetNumber,
                              @RequestParam(name = "client.clintAddress.localNumber") String localNumber,
                              @RequestParam(name = "clientComment") String comment,
                              @RequestParam(name = "decision") String pushedButton,
                              @ModelAttribute("basket") ShoppingCart shoppingCart) {


        order.setOrderAddress(new Address(street,streetNumber,localNumber,postalCode,city));
        order.setClientComment(comment);
        order.setClient(new Client(clientName, clientSurname));
        order.setOrderCreationDate(LocalDateTime.now());
        order.setCart(shoppingCart);

        if ("Submit".equalsIgnoreCase(pushedButton)) {
            log.info("ORDER = " + order.toString());
            orderService.createOrder(order);
        }

        return "redirect:/main";
    }

    /*@GetMapping("/order/finalize")
    public String finalizingOrder(Model model, @ModelAttribute("basker")ShoppingCart shoppingCart) {
        log.info("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        model.addAttribute("order", new Order());
        return "order-final";
    }*/
}
