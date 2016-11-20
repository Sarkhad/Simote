package org.simote.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping( value = "/profile" )
public class ProfileController {

	@RequestMapping
	public String get() {
		return "";
	}
	
	@RequestMapping( value = "/profile/{nickname}" )
	public String getUserProfile( @PathVariable(required = true) String nickname ) {
		return "profile";
	}
}
