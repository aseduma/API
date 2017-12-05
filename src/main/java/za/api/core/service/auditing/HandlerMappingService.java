package za.api.core.service.auditing;

import za.api.core.model.auditing.HandlerMapping;

import java.util.List;

/**
 * Created by Azael on 2017/12/05.
 */
public interface HandlerMappingService {
    List<HandlerMapping> getAll();

    void save(HandlerMapping handlerMapping);
    void update(HandlerMapping handlerMapping);
    void delete(HandlerMapping handlerMapping);
}
