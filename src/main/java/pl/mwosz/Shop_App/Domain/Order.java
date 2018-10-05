package pl.mwosz.Shop_App.Domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "ORDER_DB")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne    // ?? to nie jest Entity
    private ShoppingCart cart;
    @OneToOne
    private Client client;
    @OneToOne
    private PaymentMethod paymentMethod;
    @OneToOne
    private Address orderAddress;
    private LocalDateTime orderCreationDate;
    private String clientComment;

    public Order() {
    }

    public Order(ShoppingCart cart, Client client, PaymentMethod paymentMethod, Address orderAddress, String clientComment) {
        this.cart = cart;
        this.client = client;
        this.paymentMethod = paymentMethod;
        this.orderAddress = orderAddress;
        this.clientComment = clientComment;
        this.orderCreationDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", cart=" + cart +
                ", client=" + client +
                ", paymentMethod=" + paymentMethod +
                ", orderAddress=" + orderAddress +
                ", orderCreationDate=" + orderCreationDate +
                ", clientComment='" + clientComment + '\'' +
                '}';
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ShoppingCart getCart() {
        return cart;
    }

    public void setCart(ShoppingCart cart) {
        this.cart = cart;
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
        return orderAddress;
    }

    public void setOrderAddress(Address orderAddress) {
        this.orderAddress = orderAddress;
    }

    public LocalDateTime getOrderCreationDate() {
        return orderCreationDate;
    }

    public void setOrderCreationDate(LocalDateTime orderCreationDate) {
        this.orderCreationDate = orderCreationDate;
    }

    public String getClientComment() {
        return clientComment;
    }

    public void setClientComment(String clientComment) {
        this.clientComment = clientComment;
    }
}
