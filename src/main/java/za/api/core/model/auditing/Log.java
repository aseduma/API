package za.api.core.model.auditing;

import javax.persistence.*;

/**
 * Created by Azael on 2017/11/30.
 */
@Entity
@Table(catalog = "core")
public class Log extends Auditor<String>{
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String clientIp;

    @Column(nullable = false)
    private String accessedUrl;

    @Lob
    private String error;

    private Integer httpStatusCode;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getAccessedUrl() {
        return accessedUrl;
    }

    public void setAccessedUrl(String accessedUrl) {
        this.accessedUrl = accessedUrl;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Integer getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(Integer httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }
}
