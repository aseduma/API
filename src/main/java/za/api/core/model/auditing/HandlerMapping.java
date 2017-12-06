package za.api.core.model.auditing;

import javax.persistence.*;

/**
 * Created by Azael on 2017/12/01.
 */
@Entity
@Table(catalog = "core")
public class HandlerMapping extends Auditor<String>{
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String className;

    @Lob
    private String description;

    @Column(nullable = false)
    @Lob
    private String requestMapping;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequestMapping() {
        return requestMapping;
    }

    public void setRequestMapping(String requestMapping) {
        this.requestMapping = requestMapping;
    }
}
