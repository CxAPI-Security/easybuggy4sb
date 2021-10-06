package org.t246osslab.easybuggy4sb.errors;

import javax.xml.transform.TransformerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.t246osslab.easybuggy4sb.Config;

@Controller
public class TransformerFactoryConfigurationErrorController {

	@RequestMapping(value = Config.APP_ROOT + "/tfce")
	public void process() {
        System.setProperty("javax.xml.transform.TransformerFactory", "a");
        TransformerFactory.newInstance();
	}
}
