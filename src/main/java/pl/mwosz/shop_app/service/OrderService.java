package pl.mwosz.shop_app.service;

import pl.mwosz.shop_app.domain.Order;

public interface OrderService {

    boolean createOrder(Order order);
}
