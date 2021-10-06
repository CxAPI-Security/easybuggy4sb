package org.t246osslab.easybuggy4sb.errors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.t246osslab.easybuggy4sb.Config;

@Controller
public class OutOfMemoryErrorController {

	@RequestMapping(value = Config.APP_ROOT + "/oome")
	public void process() {
		StringBuilder sb = new StringBuilder();
		while (true) {
			sb.append("OutOfMemoryError!");
		}
	}
}
