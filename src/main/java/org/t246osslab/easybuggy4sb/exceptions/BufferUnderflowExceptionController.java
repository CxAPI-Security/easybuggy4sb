package org.t246osslab.easybuggy4sb.exceptions;

import java.nio.ByteBuffer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.t246osslab.easybuggy4sb.Config;

@Controller
public class BufferUnderflowExceptionController {

	@RequestMapping(value = Config.APP_ROOT + "/bue")
	public void process() {
		ByteBuffer.wrap(new byte[]{1}).getDouble();
	}
}