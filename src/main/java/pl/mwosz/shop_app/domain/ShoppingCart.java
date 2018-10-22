package pl.mwosz.shop_app.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<SingleOrderItem> orderList;

    public ShoppingCart() {
    }

    public ShoppingCart(List<SingleOrderItem> orderList) {
        this.orderList = orderList;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "id=" + id +
                ", orderList=" + orderList +
                '}';
    }

    public List<SingleOrderItem> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<SingleOrderItem> orderList) {
        this.orderList = orderList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void addProductToCart(Product product) {
        orderList.add(new SingleOrderItem(product, 1));
    }
}
