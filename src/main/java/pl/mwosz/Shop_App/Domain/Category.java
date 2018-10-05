package pl.mwosz.Shop_App.Domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Optional;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    /*@OneToOne
    private Optional<Category> productCategory;*/
    private LocalDateTime categoryCreationDateTime;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
        this.categoryCreationDateTime = LocalDateTime.now(); // w ten sposob przy tworzeniu nowej kategorii zawsze bedzie data utworzenia?
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

    /*public Optional<Category> getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(Optional<Category> productCategory) {
        this.productCategory = productCategory;
    }*/

    public LocalDateTime getCategoryCreationDateTime() {
        return categoryCreationDateTime;
    }

    public void setCategoryCreationDateTime(LocalDateTime categoryCreationDateTime) {
        this.categoryCreationDateTime = categoryCreationDateTime;
    }
}
