package org.t246osslab.easybuggy4sb.exceptions;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.t246osslab.easybuggy4sb.Config;

@Controller
public class IllegalArgumentExceptionController {

    @RequestMapping(value = Config.APP_ROOT + "/iae")
    public void process(ModelAndView mav) {
        mav.addObject(new ArrayList<Object>(-1));
    }
}
