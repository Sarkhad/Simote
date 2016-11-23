package org.simote.controller;

import org.simote.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping( value = "/admin" )
public class AdminPanelController {
	
	@Autowired
	SecurityService securityService;
	
	@GetMapping
	public String get() {		
		if( !securityService.hasRole("ADMIN") ) {
			return "redirect:/";
		}
		
		return "admin";
	}

}
