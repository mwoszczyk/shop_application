package pl.mwosz.Shop_App.Domain;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "CLIENT_DB")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    @OneToOne
    private Address clintAddress;
    @OneToOne
    private User userId;

    public Client() {
    }

    public Client(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Client(String name, String surname, Address clintAddress, User userId) {
        this.name = name;
        this.surname = surname;
        this.clintAddress = clintAddress;
        this.userId = userId;
    }


    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", clintAddress=" + clintAddress +
                ", userId=" + userId +
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Address getClintAddress() {
        return clintAddress;
    }

    public void setClintAddress(Address clintAddress) {
        this.clintAddress = clintAddress;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }
}
