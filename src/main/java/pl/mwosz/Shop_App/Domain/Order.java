package pl.mwosz.Shop_App.Domain;

import com.sun.javafx.collections.MappingChange;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.*;

@Entity
@Table(name = "ORDER_DB")
public class Order {

    //    private Map<Product, Integer> productList;    // mapowanie jest tu potrzebne?

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
    private List<Position> list = Collections.EMPTY_LIST; // ma to sens??
    @OneToOne
    private Client client;
    private PaymentMethod paymentMethod;            // mapowanie jest tu potrzebne? ...
    @OneToOne
    private Address OrderAddress;
    private Date orderDate;
    private BigDecimal minimumOrderPrice;

    public Order() {
    }

    public Order(List<Position> list, Client client, PaymentMethod paymentMethod, Address orderAddress, Date orderDate, BigDecimal minimumOrderPrice) {
        this.list = list;
        this.client = client;
        this.paymentMethod = paymentMethod;
        OrderAddress = orderAddress;
        this.orderDate = orderDate;
        this.minimumOrderPrice = minimumOrderPrice;
    }

    /*public BigDecimal orderPrice() {
        BigDecimal orderPrice = BigDecimal.ZERO;
        if (productList.size() > 0) {
            for (Product p : productList.keySet()) {
                orderPrice.add(p.getPrice().multiply(BigDecimal.valueOf(productList.get(p))));   // <------------------- dlaczego nie trybi "add"?
            }
        }
        return orderPrice;
    }

    public void orderPositionPrices() {
        for (Product p : productList.keySet()) {
            System.out.println(String.format("Product [%s], price [%s]", p.getName(), p.getPrice()));
        }
    }

    public void addProduct(Product product, Integer quantity) {
        Product productExistence = null;
        for (Product tmp : productList.keySet()) {
            if (tmp.getName().equals(product.getName())) {
                productExistence = tmp;
                break;
            }
        }
        if (productExistence !=  null) {
            Integer productQuantity = quantity + productList.get(productExistence);
            productList.put(product, productQuantity);
            System.out.println(String.format("Updated quantity [%s] to existing product [%s] ", quantity, product));
        } else {
            productList.put(product, quantity);
            System.out.println(String.format("Added new product [%s] with quantity [%s]", product, quantity));
        }
    }

    public void deleteProduct(Product product) {
        for (Product tmp : productList.keySet()) {
            if (tmp.getName().equals(product.getName())) {
                Integer deleteResult = productList.remove(tmp);
                if (deleteResult != null) {
                    System.out.println("Delete complite");
                } else {
                    System.out.println("Delete failed");
                }
            }
        }
    }

    public void editOrderPosition(Product product) {    // za dluga metoda?
        Scanner sc = new Scanner(System.in);
        for (Product p : productList.keySet()) {
            if (p.getName().equals(product.getName())) {
                boolean productEdition = true;
                Integer quantitySave = productList.get(product);
                while (productEdition) {
                    System.out.println("Press [1] to change product");
                    System.out.println("Press [2] to change quantity");
                    System.out.println("Press [3] to escape edition");
                    int choice = sc.nextInt();
                    if (choice == 1) {
                        System.out.println("Insert product name:");
                        String newProductName = sc.nextLine();
                        System.out.println("Insert product price:");
                        BigDecimal newProductPrice = sc.nextBigDecimal();
                        System.out.println(String.format("Do u want to save product [%s] with quantity [%s] ?", product, quantitySave));
                        System.out.println("Press [1] to accept");
                        System.out.println("Press [2] to resign");
                        int saveChoice = sc.nextInt();
                        if (saveChoice == 1) {
                            Product newProduct = new Product(newProductName, newProductPrice);
                            productList.put(newProduct, quantitySave);
                        } else if (saveChoice == 2) {
                            System.out.println("Returning to options");
                            break;
                        } else {
                            System.out.println("Unknown choice, returning to options");
                            break;
                        }
                    } else if (choice == 2) {
                        System.out.println(String.format("Editing product quantity [%s]", product));
                        System.out.println("Insert quantity:");
                        Integer newQuantity = sc.nextInt();
                        productList.replace(product, quantitySave, newQuantity);
                    } else if (choice == 3) {
                        productEdition = false;
                    }
                }
            }
        }
        sc.close();
    }*/

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", list=" + list +
                ", client=" + client +
                ", paymentMethod=" + paymentMethod +
                ", OrderAddress=" + OrderAddress +
                ", orderDate=" + orderDate +
                ", minimumOrderPrice=" + minimumOrderPrice +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /*public Map<Product, Integer> getProductList() {
        return productList;
    }

    public void setProductList(Map<Product, Integer> productList) {
        this.productList = productList;
    }*/

    public List<Position> getList() {
        return list;
    }

    public void setList(List<Position> list) {
        this.list = list;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Address getOrderAddress() {
        return OrderAddress;
    }

    public void setOrderAddress(Address orderAddress) {
        OrderAddress = orderAddress;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getMinimumOrderPrice() {
        return minimumOrderPrice;
    }

    public void setMinimumOrderPrice(BigDecimal minimumOrderPrice) {
        this.minimumOrderPrice = minimumOrderPrice;
    }
}
