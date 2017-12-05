package za.api.core.model.auditing;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import za.api.core.model.user.User;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * Created by Azael on 2017/11/30.
 */
@MappedSuperclass
public class Auditor {

    @LastModifiedBy
    @ManyToOne
    @JoinColumn
    private User modifiedBy;

    @CreatedBy
    @ManyToOne
    @JoinColumn(updatable = false)
    private User createdBy;

    @UpdateTimestamp
    @ColumnDefault(value = "CURRENT_TIMESTAMP")
    @Column(nullable = false)
    private Date modifiedTimestamp;

    @CreationTimestamp
    @ColumnDefault(value = "CURRENT_TIMESTAMP")
    @Column(nullable = false, updatable = false)
    private Date createdTimestamp;
}
