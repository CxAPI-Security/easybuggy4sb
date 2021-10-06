package org.t246osslab.easybuggy4sb.exceptions;

import java.awt.geom.GeneralPath;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.t246osslab.easybuggy4sb.Config;

@Controller
public class IllegalPathStateExceptionController {

    @RequestMapping(value = Config.APP_ROOT + "/ipse")
    public void process() {
        GeneralPath subPath = new GeneralPath(GeneralPath.WIND_EVEN_ODD, 100);
        subPath.closePath();
    }
}
