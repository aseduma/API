package za.api.core.service.auditing;

import za.api.core.model.auditing.Log;

import java.util.List;

/**
 * Created by Azael on 2017/11/30.
 */
public interface LogService {
    Log getById(Integer id);

    List<Log> getAll();
    List<Log> getByAccessedUrl(String accessedUrl);
    List<Log> getByClientIp(String clientIp);
    List<Log> getByHttpStatusCode(Integer httpStatusCode);

    void save(Log log);
    void update(Log log);
    void delete(Log log);
}
