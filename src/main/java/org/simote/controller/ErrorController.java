package org.simote.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class ErrorController {

	@RequestMapping( "/error/notfound" )
	public String notFoundPage() {
		return "notFound";
	}
	
	@RequestMapping( "/error/forbidden" )
	public String forbiddenPage() {
		return "forbidden";
	}
	
	/*
	@RequestMapping( value = "/error" )
	public String notFoundPageRedirector() {
		return "redirect:/error/notfound";

	}*/
	
}
