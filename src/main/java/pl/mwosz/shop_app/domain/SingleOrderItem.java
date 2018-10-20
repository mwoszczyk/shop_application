package pl.mwosz.shop_app.domain;


import javax.persistence.*;

// ta klasa powinna byc Entity?? jak o tym myslec, kiedy NAPRAWDE potrzebuje @Entity?
@Entity
@Table(name = "Position_DB")
public class SingleOrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Product product;
    private int quantity;

    public SingleOrderItem() {
    }

    public SingleOrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "SingleOrderItem{" +
                "id=" + id +
                ", product=" + product +
                ", quantity=" + quantity +
                '}';
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
