package org.simote.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping( value = "/admin" )
public class AdminPanelController {

	public String getPage() {
		return "admin";
	}
	
	
}
