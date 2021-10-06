package org.t246osslab.easybuggy4sb.exceptions;

import java.util.Scanner;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.t246osslab.easybuggy4sb.Config;

@Controller
public class InputMismatchExceptionController {

    @RequestMapping(value = Config.APP_ROOT + "/ime")
    public void process() {
        try (Scanner scanner = new Scanner("a")) {
            scanner.nextInt();
        }
    }
}
