package za.api.core.model.auditing;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * Created by Azael on 2017/11/30.
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditor<U> {

    @LastModifiedBy
    private U modifiedBy;

    @CreatedBy
    @Column(updatable = false)
    private U createdBy;

    @LastModifiedDate
    private Date modifiedDate;

    @CreatedDate
    @Column(updatable = false)
    private Date createdDate;

}
