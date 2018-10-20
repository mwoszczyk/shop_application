package pl.mwosz.shop_app.service.implementations;

import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mwosz.shop_app.dao.OrderDao;
import pl.mwosz.shop_app.domain.Order;
import pl.mwosz.shop_app.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao;

    @Autowired
    public OrderServiceImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public boolean createOrder(Order order) {
        Order orderSaveResult = orderDao.save(order);
        return null != orderSaveResult.getId();
    }
}
