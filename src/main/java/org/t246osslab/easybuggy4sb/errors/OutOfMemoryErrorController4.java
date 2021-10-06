package org.t246osslab.easybuggy4sb.errors;

import java.util.Properties;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.t246osslab.easybuggy4sb.Config;

@Controller
public class OutOfMemoryErrorController4 {

	@RequestMapping(value = Config.APP_ROOT + "/oome4")
	public void process() {
		Properties properties = System.getProperties();
		Random r = new Random();
		while (true) {
			properties.put(r.nextInt(), "value");
		}
	}
}
