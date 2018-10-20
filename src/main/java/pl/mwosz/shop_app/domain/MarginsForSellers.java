package pl.mwosz.shop_app.domain;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class MarginsForSellers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Product product;
    private BigDecimal minimumPrice;
    private double profitPercentage;
    // polaczyc z magazynem?? cale wyswietlanie dla sprzedajacego wlacznie z iloscia magazynowa? <MAGAZYN>

    public MarginsForSellers() {
    }

    public MarginsForSellers(Product product, BigDecimal minimumPrice, double profitPercentage) {
        this.product = product;
        this.minimumPrice = minimumPrice;
        this.profitPercentage = profitPercentage;
    }

    @Override
    public String toString() {
        return "MarginsForSellers{" +
                "id=" + id +
                ", product=" + product +
                ", minimumPrice=" + minimumPrice +
                ", profitPercentage=" + profitPercentage +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BigDecimal getMinimumPrice() {
        return minimumPrice;
    }

    public void setMinimumPrice(BigDecimal minimumPrice) {
        this.minimumPrice = minimumPrice;
    }

    public double getProfitPercentage() {
        return profitPercentage;
    }

    public void setProfitPercentage(double profitPercentage) {
        this.profitPercentage = profitPercentage;
    }
}
