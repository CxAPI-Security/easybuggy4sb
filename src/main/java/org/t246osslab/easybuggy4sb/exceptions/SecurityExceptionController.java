package org.t246osslab.easybuggy4sb.exceptions;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.t246osslab.easybuggy4sb.Config;

@Controller
public class SecurityExceptionController {

    @RequestMapping(value = Config.APP_ROOT + "/se")
    public void process() {
        new SecurityManager().checkPermission(new RuntimePermission("exitVM"), null);
    }
}
