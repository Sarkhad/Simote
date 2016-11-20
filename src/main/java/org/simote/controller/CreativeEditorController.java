package org.simote.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CreativeEditorController {

	@RequestMapping( value = "/personal/editor", method = RequestMethod.GET )
	public String editorPage() {
		return "personal/editor";
	}
	
}
