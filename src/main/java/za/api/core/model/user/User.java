package za.api.core.model.user;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.validator.constraints.NotBlank;
import za.api.core.model.auditing.Auditor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Set;

/**
 * Created by Azael on 2017/11/30.
 */
@Entity
@Table(catalog = "core")
public class User extends Auditor {

    @NotBlank
    @Id
    private String username;

    @NotBlank
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=.*).{6,45}$")
    @Lob
    @Column(nullable = false)
    private String hashedPassword;

    @NotNull
    @OneToOne
    @JoinColumn(nullable = false, unique = true)
    private Profile profile;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(nullable = false),
            inverseJoinColumns = @JoinColumn(nullable = false))
    private Set<Role> roles;


    @Column(nullable = false)
    @ColumnDefault("false")
    private Boolean active;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}