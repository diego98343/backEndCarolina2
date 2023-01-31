package CarolinaEcommerceBackEnd.CarolinaEcommerceBackEnd.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table( name="user_registration_form")
@NotNull()
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotNull(message = "name require")
    @Size(min = 3)
    private String name;
    @NotNull(message = "phone require")
    private Long phoneNumber;
    @NotNull
    @Size(min = 7)
    private String homeAddress;

    @NotNull(message = "passWord require")
    @Size(min = 7)
    private String passWord;
    @NotNull(message = "email require")
    @Size(min = 7)
    private String email;




    public User(int id, String name, Long phoneNumber, String homeAddress, String passWord, String email, Date dateOfBirth) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.homeAddress = homeAddress;
        this.passWord = passWord;
        this.email = email;

    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
