package za.api.core.repository.auditing;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.api.core.model.auditing.Log;

import java.util.List;

/**
 * Created by Azael on 2017/11/30.
 */
@Repository
public interface LogRepository extends JpaRepository<Log, Integer> {
    List<Log> findByAccessedUrl(String accessedUrl);
    List<Log> findByClientIp(String clientIp);
    List<Log> findByHttpStatusCode(Integer httpStatusCode);
}
