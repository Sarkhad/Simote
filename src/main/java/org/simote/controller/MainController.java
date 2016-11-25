package org.simote.controller;

import org.simote.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@Autowired
	private TagService tagService;

	@RequestMapping("/")
	public String index( Model model ) {
		model.addAttribute( "tags", tagService.getAllTags() );
		
		return "index";
	}

}