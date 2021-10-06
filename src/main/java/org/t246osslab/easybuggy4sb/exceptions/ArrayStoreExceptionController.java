package org.t246osslab.easybuggy4sb.exceptions;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.t246osslab.easybuggy4sb.Config;

@Controller
public class ArrayStoreExceptionController {

	@RequestMapping(value = Config.APP_ROOT + "/ase")
	public void process() {
		Object[] objects = new String[1];
		objects[0] = Integer.valueOf(1);
	}
}