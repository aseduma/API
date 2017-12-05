package za.api.core.controller.auditing;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Azael on 2017/12/01.
 */
@RestController
@RequestMapping("/rest/")
@Secured(value = "ADMIN")
public class LogRestController {
}
