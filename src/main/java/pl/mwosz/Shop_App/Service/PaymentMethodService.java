package pl.mwosz.Shop_App.Service;

import pl.mwosz.Shop_App.Domain.PaymentMethod;

import java.util.List;
import java.util.Optional;

public interface PaymentMethodService {

    List<PaymentMethod> allPaymentMethods();
    boolean saveNewPaymentMethod(PaymentMethod paymentMethod);
    Optional<PaymentMethod> findPaymentMethodById(Long id);
    void deletePaymentMethodById(Long id);
}
