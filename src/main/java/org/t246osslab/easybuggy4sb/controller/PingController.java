package org.t246osslab.easybuggy4sb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.t246osslab.easybuggy4sb.Config;

@Controller
public class PingController {

	@RequestMapping(value = Config.APP_ROOT + "/ping")
	public ModelAndView hello(ModelAndView mav) {
		mav.setViewName(Config.TEMPLATE_PREFIX + "ping");
		return mav;
	}
}