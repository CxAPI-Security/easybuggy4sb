package org.t246osslab.easybuggy4sb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Date;

@RestController
@RequestMapping("authed")
public class CxAuthedController {

	@GetMapping("getTime") // require auth
	public String getTime() {
		return new Date().toString();
	}

	// curl localhost:8080/authed/runCommand/whoami
	@GetMapping("runCommand/{cmd}")
	public String runCommand(@PathVariable String cmd) throws IOException {
		byte[] buf = new byte[1024];
		Runtime.getRuntime().exec(cmd).getInputStream().read(buf);
		return new String(buf);
	}
}
