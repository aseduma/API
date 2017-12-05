package za.api.core.repository.auditing;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.api.core.model.auditing.HandlerMapping;

/**
 * Created by Azael on 2017/12/05.
 */
@Repository
public interface HandlerMappingRepository extends JpaRepository<HandlerMapping, Integer> {

}
