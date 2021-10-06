package org.t246osslab.easybuggy4sb.troubles;

import java.io.IOException;

import javax.servlet.ServletException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.t246osslab.easybuggy4sb.Config;

@Controller
public class ForwardLoopController {

    @RequestMapping(value = Config.APP_ROOT + "/forwardloop")
    public String process() throws IOException, ServletException {
    	return "forward:forwardloop";
    }
}