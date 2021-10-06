package org.t246osslab.easybuggy4sb.troubles;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.t246osslab.easybuggy4sb.Config;

@Controller
public class RedirectLoopController {

    @RequestMapping(value = Config.APP_ROOT + "/redirectloop")
    public String process() throws IOException {
        return "redirect:redirectloop";
    }
}