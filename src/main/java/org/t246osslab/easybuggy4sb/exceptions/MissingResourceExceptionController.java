package org.t246osslab.easybuggy4sb.exceptions;

import java.util.ResourceBundle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.t246osslab.easybuggy4sb.Config;

@Controller
public class MissingResourceExceptionController {

 	@RequestMapping(value = Config.APP_ROOT + "/mre")
	public void process() {
	    ResourceBundle.getBundle("");
	}
}