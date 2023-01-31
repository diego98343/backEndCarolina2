package CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.model.checkOut;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
@Table(name="address")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String street;
    private String city;
    private String country;
    private String zipcode;
    @OneToOne
    @PrimaryKeyJoinColumn
    private Order order;


    public Address(int  id, String street, String city, String country, String zipcode, Order order) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.country = country;
        this.zipcode = zipcode;
        this.order = order;
    }

    public Address() {
    }


    public long getId() {
        return id;
    }

    public void setId(int  id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
