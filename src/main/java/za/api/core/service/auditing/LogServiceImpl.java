package za.api.core.service.auditing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.api.core.model.auditing.Log;
import za.api.core.repository.auditing.LogRepository;

import java.util.List;

/**
 * Created by Azael on 2017/11/30.
 */
@Service
public class LogServiceImpl implements LogService{
    @Autowired
    private LogRepository logRepository;


    @Override
    public Log getById(Integer id) {
        return logRepository.findOne(id);
    }

    @Override
    public List<Log> getAll() {
        return logRepository.findAll();
    }

    @Override
    public List<Log> getByAccessedUrl(String accessedUrl) {
        return logRepository.findByAccessedUrl(accessedUrl);
    }

    @Override
    public List<Log> getByClientIp(String clientIp) {
        return logRepository.findByClientIp(clientIp);
    }

    @Override
    public List<Log> getByHttpStatusCode(Integer httpStatusCode) {
        return logRepository.findByHttpStatusCode(httpStatusCode);
    }

    @Override
    public void save(Log log) {
        logRepository.save(log);
    }

    @Override
    public void update(Log log) {
        logRepository.save(log);
    }

    @Override
    public void delete(Log log) {
        logRepository.delete(log);
    }
}
