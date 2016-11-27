package org.simote.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import org.simote.domain.content.Chapter;
import org.simote.domain.content.Creative;
import org.simote.service.CreativeService;
import org.simote.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@Autowired
	private TagService tagService;
	
	@Autowired
	private CreativeService creativeService;
	
	@RequestMapping("/")
	public String index( Model model ) {
		model.addAttribute( "tags", tagService.getAllTags() );
		
		return "index";
	}
	
	@GetMapping("/creative/")
	public String viewEmptyCreative() {
		return "redirect:/";	
	} 
	
	@RequestMapping( value = "/creative/{id}" )
	public String viewCreative( @PathVariable( value = "id", required = true ) int id, Model model ) {
		Creative creative = creativeService.getCreative(id);
		
		if( creative == null ) return "creative/creativeNotFound";
 		
		ArrayList<Chapter> chapters = new ArrayList<Chapter>( creative.getChapters() );
		
		Collections.sort( chapters, new Comparator<Chapter>(){
			public int compare(Chapter o1, Chapter o2) {
				if( o1.getChapterOrder() > o2.getChapterOrder() ) return 1; else return -1;
			}
			
		});
		
		model.addAttribute( "creative", creative );
		model.addAttribute( "chapters", chapters );
		
		return "creative/creative";
	}

}