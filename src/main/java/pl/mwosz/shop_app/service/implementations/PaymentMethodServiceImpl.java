package pl.mwosz.shop_app.service.implementations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mwosz.shop_app.dao.PaymentMethodDao;
import pl.mwosz.shop_app.domain.PaymentMethod;
import pl.mwosz.shop_app.service.PaymentMethodService;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentMethodServiceImpl implements PaymentMethodService {

    private static final Logger log = LoggerFactory.getLogger(PaymentMethodServiceImpl.class);
    private PaymentMethodDao paymentMethodDao;

    @Autowired
    public PaymentMethodServiceImpl(PaymentMethodDao paymentMethodDao) {
        this.paymentMethodDao = paymentMethodDao;
    }

    @Override
    public List<PaymentMethod> allPaymentMethods() {
        log.info("Listing all PaymentMethods from PaymentMethodsServiceImpl....");
        return (List<PaymentMethod>) paymentMethodDao.findAll();
    }

    @Override
    public boolean saveNewPaymentMethod(PaymentMethod paymentMethod) {
        log.info(String.format("Saving new Payment Method: [%s]", paymentMethod));

        PaymentMethod paymentMethodSaveResult = paymentMethodDao.save(paymentMethod);

        return null != paymentMethodSaveResult.getId();
    }

    @Override
    public Optional<PaymentMethod> findPaymentMethodById(Long id) {
        log.info(String.format("[PaymentMethodServiceImpl] - Searching for Payment Method by id: [%s]", id));
        return paymentMethodDao.findById(id);
    }

    @Override
    public void deletePaymentMethodById(Long id) {
        paymentMethodDao.deleteById(id);
    }
}
