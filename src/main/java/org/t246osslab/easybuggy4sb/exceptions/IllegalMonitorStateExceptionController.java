package org.t246osslab.easybuggy4sb.exceptions;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.t246osslab.easybuggy4sb.Config;

@Controller
public class IllegalMonitorStateExceptionController {

    @RequestMapping(value = Config.APP_ROOT + "/imse")
    public void process() {
        Thread thread = new Thread();
        thread.start();
        try {
            thread.wait();
        } catch (InterruptedException e) {
        }
    }
}
