package pl.mwosz.Shop_App.Domain;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class ProductConverter implements AttributeConverter<Product, String> {


    @Override
    public String convertToDatabaseColumn(Product attribute) {
        return attribute.getName();
    }

    @Override
    public Product convertToEntityAttribute(String dbData) {
        return new Product();
    }
}
