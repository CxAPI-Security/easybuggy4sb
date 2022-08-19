package org.t246osslab.easybuggy4sb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.t246osslab.easybuggy4sb.Config;
import org.t246osslab.easybuggy4sb.vulnerabilities.SQLInjectionController;

@Controller
public class PingController {
	@Autowired
	private SQLInjectionController sqlInjectionController;

	@RequestMapping(value = Config.APP_ROOT + "/ping")
	public ModelAndView hello(ModelAndView mav,@RequestParam(value = "phone", required = false)  String phone) {
		mav.setViewName(Config.TEMPLATE_PREFIX + "phone");
		sqlInjectionController.doPong(pong);
		return mav;
	}
}