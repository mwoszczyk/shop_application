package pl.mwosz.Shop_App.Service.Implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mwosz.Shop_App.Dao.OrderDao;
import pl.mwosz.Shop_App.Service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao;

    @Autowired
    public OrderServiceImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public boolean createOrder() {
        return false;
    }
}
