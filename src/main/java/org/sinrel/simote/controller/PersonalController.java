package org.sinrel.simote.controller;

import java.util.List;

import org.sinrel.simote.domain.content.Award;
import org.sinrel.simote.domain.user.User;
import org.sinrel.simote.service.AwardService;
import org.sinrel.simote.service.CreativeService;
import org.sinrel.simote.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping( value = "personal" )
public class PersonalController {
	
	@Autowired
	private SecurityService securityService;
	
	@Autowired
	private AwardService awardService;
	
	@Autowired
	private CreativeService creativeService;
	
	@ModelAttribute("awards")
	private List<Award> getAwards() {
		return awardService.sortAwardsByAwardedTime( securityService.getLoggedInUser().getAwards() );
	}
	
	@RequestMapping( method = RequestMethod.GET )
	public String get( Model model ) {
		User user = securityService.getLoggedInUser();
		
		model.addAttribute( "user", user );
		model.addAttribute( "creatives", creativeService.sortCreativesByCreatedDesc( user.getCreatives() ) );
		
		return "personal/personal";
	}
		
}
