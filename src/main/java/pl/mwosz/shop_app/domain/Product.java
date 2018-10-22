package pl.mwosz.shop_app.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "PRODUCT_DB")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal price;

    private String description;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Category category;
    private LocalDateTime productCreationDateTime;

    public Product() {
    }

    public Product(String name, BigDecimal price, String description, Category category) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
        this.productCreationDateTime = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", category=" + category +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public LocalDateTime getProductCreationDateTime() {
        return productCreationDateTime;
    }

    public void setProductCreationDateTime(LocalDateTime productCreationDateTime) {
        this.productCreationDateTime = productCreationDateTime;
    }
}
