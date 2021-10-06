package org.t246osslab.easybuggy4sb.errors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.t246osslab.easybuggy4sb.Config;

@Controller
public class AssertionErrorController {

    @RequestMapping(value = Config.APP_ROOT + "/asserr")
    public void process() {
        assert false : "Invalid!";
    }
}
