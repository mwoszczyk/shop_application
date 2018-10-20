package pl.mwosz.shop_app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.mwosz.shop_app.domain.PaymentMethod;
import pl.mwosz.shop_app.service.PaymentMethodService;

import java.util.Optional;

@Controller
public class PaymentMethodController {

    private PaymentMethodService paymentMethodService;
    private Logger log = LoggerFactory.getLogger(PaymentMethodController.class);

    @Autowired
    public PaymentMethodController(PaymentMethodService paymentMethodService) {
        this.paymentMethodService = paymentMethodService;
    }

    @GetMapping("/paymentMethod/all")
    public String allPaymentMethods(Model model) {
        log.info("Listing all payment methods from PaymentMethodController....");
        model.addAttribute("allPaymentMethods", paymentMethodService.allPaymentMethods());
        return "paymentMethod/paymentMethod-all";
    }

    @GetMapping("/paymentMethod/add")
    public String addPaymentMethod(Model model) {

        log.info("addPaymentMethod() from PaymentMethodController....");

        model.addAttribute("newPayMeth", new PaymentMethod());
        model.addAttribute("title", "New");
        model.addAttribute("paragraph", "New");

        return "paymentMethod/paymentMethod-add-edit";
    }

    @PostMapping("/paymentMethod/save")
    public String paymentMethodSave(@ModelAttribute PaymentMethod paymentMethod,
                                    @RequestParam(name = "decision") String decision) {
        log.info(String.format("paymentMethodSave() from PaymentMethodController.... PaymentMethod: [%s]", paymentMethod.getName()));

        switch (decision) {
            case "Save":
                log.info(String.format("Admin confirmed saving new Payment Method: [%s]", paymentMethod));
                paymentMethodService.saveNewPaymentMethod(paymentMethod);
                log.info(String.format("Successfull save of Payment Method: [%s]", paymentMethod));
                return "redirect:/paymentMethod/all";
                default:
                    return "redirect:/paymentMethod/all";
        }
    }

    @GetMapping("/paymentMethod/edit/{id}")
    public String paymentMethodEdit(@PathVariable("id") long id, Model model) {
        log.info(String.format("[PaymentMethodController] - Seatching for Payment Method by id: [%s]", id));

        Optional<PaymentMethod> paymentMethodExistance = paymentMethodService.findPaymentMethodById(id);
        paymentMethodExistance.ifPresent(paymentMethod -> model.addAttribute("newPayMeth", paymentMethod)); // on zawsze widzi tutan "new PaymentMethod" ????
        model.addAttribute("title", "Edit");
        model.addAttribute("paragraph", "Edit");

        return "paymentMethod/paymentMethod-add-edit";
    }

    @GetMapping("/paymentMethod/delete/choice/{id}")
    public String payMethDeleteChoice(@PathVariable("id") long id, Model model) {
        log.info(String.format("[PaymentMethodController] - Delete choice of payment Method id: [%s]", id));
        model.addAttribute("payMethId", id);
        return "paymentMethod/paymentMethod-deleteConfirm";
    }

    @GetMapping("/paymentMethod/delete/{id}")
    public String deletePayMethById(@PathVariable("id") long id) {
        log.info(String.format("[PaymentMethodController] - Deleting Payment Method by id: [%s]", id));
        paymentMethodService.deletePaymentMethodById(id);
        return "redirect:/paymentMethod/all";
    }
}
