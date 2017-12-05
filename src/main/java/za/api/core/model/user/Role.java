package za.api.core.model.user;

import za.api.core.model.auditing.Auditor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Azael on 2017/11/30.
 */
@Entity
@Table(catalog = "core")
public class Role extends Auditor {

    @Id
    @Column(length = 15)
    private String name;

    @Column(nullable = false, unique = true, length = 30)
    private String description;

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
}
