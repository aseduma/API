package za.api.core.service.auditing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.api.core.model.auditing.HandlerMapping;
import za.api.core.repository.auditing.HandlerMappingRepository;

import java.util.List;

/**
 * Created by Azael on 2017/12/05.
 */
@Service
public class HandlerMappingServiceImpl implements HandlerMappingService {
    @Autowired
    private HandlerMappingRepository handlerMappingRepository;


    @Override
    public List<HandlerMapping> getAll() {
        return handlerMappingRepository.findAll();
    }

    @Override
    public void save(HandlerMapping handlerMapping) {
        handlerMappingRepository.save(handlerMapping);
    }

    @Override
    public void update(HandlerMapping handlerMapping) {
        handlerMappingRepository.save(handlerMapping);
    }

    @Override
    public void delete(HandlerMapping handlerMapping) {
        handlerMappingRepository.delete(handlerMapping);
    }
}

