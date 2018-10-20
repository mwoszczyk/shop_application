package pl.mwosz.shop_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.mwosz.shop_app.domain.Address;
import pl.mwosz.shop_app.domain.Client;
import pl.mwosz.shop_app.domain.Order;
import pl.mwosz.shop_app.service.*;

@Controller
public class OrderController {

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
    public String creatingOrder(Model model) {
        model.addAttribute("order", new Order());
        model.addAttribute("payMeth", paymentMethodService.allPaymentMethods());
        return "basket/order-save";
    }

    @PostMapping("/order/save")
    public String savingOrder(@ModelAttribute Order order,
                              @RequestParam(name = "clientName") String clientName,
                              @RequestParam(name = "clientSurname") String clientSurname,
                              @RequestParam(name = "city") String city,
                              @RequestParam(name = "postalCode") Integer postalCode,
                              @RequestParam(name = "street") String street,
                              @RequestParam(name = "streetNumber") String streetNumber,
                              @RequestParam(name = "localNumber") String localNumber,
                              @RequestParam(name = "comment") String comment,
                              @RequestParam(name = "decision") String pushedButton) {

        order.setOrderAddress(new Address(street,streetNumber,localNumber,postalCode,city));
        order.setClientComment(comment);
        order.setClient(new Client(clientName, clientSurname));

        if ("Submit".equalsIgnoreCase(pushedButton)) {
            orderService.createOrder(order);
        }

        return "redirect:/main";
    }
}
