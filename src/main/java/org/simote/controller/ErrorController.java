package org.simote.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ErrorController {

    @ExceptionHandler(Throwable.class)
    //@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String exception(final Throwable throwable, final Model model) {
        String errorMessage = (throwable != null ? throwable.getMessage() : "Unknown error");
        model.addAttribute("errorMessage", errorMessage);
        return "error";
    }
	
	
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
