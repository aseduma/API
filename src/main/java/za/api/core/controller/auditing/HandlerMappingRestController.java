package za.api.core.controller.auditing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import za.api.core.service.auditing.HandlerMappingService;

import java.util.Map;

/**
 * Created by Azael on 2017/12/01.
 */
@RestController
@RequestMapping("/rest/structures")
@Secured("ANONYMOUS")
public class HandlerMappingRestController {
    private final RequestMappingHandlerMapping requestMappingHandlerMapping;
    private final HandlerMappingService handlerMappingService;

    @Autowired
    public HandlerMappingRestController(RequestMappingHandlerMapping requestMappingHandlerMapping,
                                        HandlerMappingService handlerMappingService) {
        this.requestMappingHandlerMapping = requestMappingHandlerMapping;
        this.handlerMappingService = handlerMappingService;
    }

    @RequestMapping
    public ResponseEntity<?> getStructures() {
        return new ResponseEntity<>(requestMappingHandlerMapping.getHandlerMethods(), HttpStatus.OK);
    }

    //@Secured(value = "ADMIN")
    @RequestMapping("/update")
    public ResponseEntity<?> updateStructures() {
        Map<RequestMappingInfo, HandlerMethod> map = requestMappingHandlerMapping.getHandlerMethods();
        return new ResponseEntity<>(requestMappingHandlerMapping.getHandlerMethods(), HttpStatus.OK);
    }

}
