package za.api.core.model.user;

import za.api.core.model.auditing.Auditor;

import javax.persistence.*;

/**
 * Created by Azael on 2017/11/30.
 */
@Entity
@Table(catalog = "core")
public class Role extends Auditor<String> {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(length = 30, nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true, length = 30)
    private String description;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Role{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
