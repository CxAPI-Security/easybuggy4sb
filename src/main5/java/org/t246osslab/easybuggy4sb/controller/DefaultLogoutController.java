package org.t246osslab.easybuggy4sb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.t246osslab.easybuggy4sb.Config;

@Controller
public class DefaultLogoutController {

	@RequestMapping(value = Config.APP_ROOT + "/logout")
	public String process(HttpSession ses) {

        ses.invalidate();
        return "redirect:" + Config.APP_ROOT + "/";
    }
}
