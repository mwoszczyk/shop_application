package pl.mwosz.Shop_App.Domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ADDRESS_DB")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String streetNumber; // in case street number 15AB - String
    private String localNumber;
    private int postalCode;
    private String city;
    private LocalDateTime addressCreationDate;

    public Address() {
    }

    public Address(String street, String streetNumber, String localNumber, int postalCode, String city) {
        this.street = street;
        this.streetNumber = streetNumber;
        this.localNumber = localNumber;
        this.postalCode = postalCode;
        this.city = city;
        this.addressCreationDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                ", localNumber='" + localNumber + '\'' +
                ", postalCode=" + postalCode +
                ", city='" + city + '\'' +
                ", addressCreationDate=" + addressCreationDate +
                '}';
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getLocalNumber() {
        return localNumber;
    }

    public void setLocalNumber(String localNumber) {
        this.localNumber = localNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDateTime getAddressCreationDate() {
        return addressCreationDate;
    }

    public void setAddressCreationDate(LocalDateTime addressCreationDate) {
        this.addressCreationDate = addressCreationDate;
    }
}
