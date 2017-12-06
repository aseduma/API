package za.api.core.model.user;

import org.hibernate.validator.constraints.Email;
import za.api.core.model.auditing.Auditor;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by Azael on 2017/11/30.
 */
@Entity
@Table(catalog = "core")
public class Profile extends Auditor<String>{

    @Id
    @GeneratedValue
    private Integer id;

    @Size(min=13 , max=13)
    @Pattern(regexp="(^$|[0-9]{13})")
    @Column(unique = true, length = 13)
    private String identityNumber;

    @Pattern(regexp="(^$|[0-9]{15})")
    @Column(unique = true, length = 15)
    private String passportNumber;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true, length = 100)
    @Email
    @Pattern(regexp = ".+@.+\\..+")
    private String email;

    @Size(min=10 , max=10)
    @Pattern(regexp="(^$|[0-9]{10})")
    @Column(nullable = false, length = 10, unique = true)
    private String cellNr;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellNr() {
        return cellNr;
    }

    public void setCellNr(String cellNr) {
        this.cellNr = cellNr;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", identityNumber='" + identityNumber + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", cellNr='" + cellNr + '\'' +
                '}';
    }
}
