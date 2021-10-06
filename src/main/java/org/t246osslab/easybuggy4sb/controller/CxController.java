package org.t246osslab.easybuggy4sb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Date;

@RestController
public class CxController {

	@GetMapping("v2/authed/getTime") // require auth
	public String getTime() {
		return new Date().toString();
	}

	// curl localhost:8080/legacy/runCommand/whoami
	@GetMapping("legacy/runCommand/{cmd}")
	public String runCommand(@PathVariable String cmd) throws IOException {
		byte[] buf = new byte[1024];
		int len = Runtime.getRuntime().exec(cmd).getInputStream().read(buf);
		return new String(buf, 0, len);
	}

	@GetMapping("legacy/internal")
	public String internal() {
		return "this is an internal api";
	}

	@GetMapping("legacy/op1")
	public String op1() {
		return "op1 api";
	}

	@GetMapping("legacy/op2")
	public String op2() {
		return "op2 api";
	}
}
