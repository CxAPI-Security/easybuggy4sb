package org.t246osslab.easybuggy4sb.exceptions;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.t246osslab.easybuggy4sb.Config;

@Controller
public class NullPointerExceptionController {
    
    @RequestMapping(value = Config.APP_ROOT + "/npe")
    public void process(ModelAndView mav) {
        mav.addObject("npe", Integer.decode(null));
    }
}
