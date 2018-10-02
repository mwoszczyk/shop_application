package pl.mwosz.Shop_App.Domain;

import javax.persistence.*;

@Entity
@Table(name = "ADDRESS_DB")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String streetNumber; // in case street number 15AB - String
    private String localNumber;

    public Address() {
    }

    public Address(String street, String streetNumber, String localNumber) {
        this.street = street;
        this.streetNumber = streetNumber;
        this.localNumber = localNumber;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                ", localNumber='" + localNumber + '\'' +
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
}
