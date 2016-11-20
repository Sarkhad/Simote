package org.simote.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( value = "/signup/rest" )
public class RestSignUpController {
	
	@RequestMapping( method = RequestMethod.GET )
	public String get() {
		return "";
	}

}
