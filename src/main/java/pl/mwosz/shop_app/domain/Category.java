package pl.mwosz.shop_app.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Optional;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToOne
    private Category productCategory;
    private LocalDateTime categoryCreationDateTime;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
        this.categoryCreationDateTime = LocalDateTime.now(); // w ten sposob przy tworzeniu nowej kategorii zawsze bedzie data utworzenia?
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", productCategory=" + productCategory +
                ", categoryCreationDateTime=" + categoryCreationDateTime +
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

    public Optional<Category> getProductCategory() {
        return Optional.ofNullable(productCategory);
    }

    public void setProductCategory(Category productCategory) {
        this.productCategory = productCategory;
    }

    public LocalDateTime getCategoryCreationDateTime() {
        return categoryCreationDateTime;
    }

    public void setCategoryCreationDateTime(LocalDateTime categoryCreationDateTime) {
        this.categoryCreationDateTime = categoryCreationDateTime;
    }
}
