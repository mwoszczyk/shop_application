package pl.mwosz.shop_app.service;

import pl.mwosz.shop_app.domain.PaymentMethod;

import java.util.List;
import java.util.Optional;

public interface PaymentMethodService {

    List<PaymentMethod> allPaymentMethods();
    boolean saveNewPaymentMethod(PaymentMethod paymentMethod);
    Optional<PaymentMethod> findPaymentMethodById(Long id);
    void deletePaymentMethodById(Long id);
}
