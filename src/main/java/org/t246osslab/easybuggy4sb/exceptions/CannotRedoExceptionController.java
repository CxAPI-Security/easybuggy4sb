package org.t246osslab.easybuggy4sb.exceptions;

import javax.swing.undo.UndoManager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.t246osslab.easybuggy4sb.Config;

@Controller
public class CannotRedoExceptionController {

	@RequestMapping(value = Config.APP_ROOT + "/cre")
	public void process() {
		new UndoManager().redo();
	}
}