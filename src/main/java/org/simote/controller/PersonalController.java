package org.simote.controller;

import java.util.HashSet;
import java.util.List;

import org.apache.log4j.Logger;
import org.simote.domain.content.Award;
import org.simote.domain.content.Creative;
import org.simote.domain.user.User;
import org.simote.service.AwardService;
import org.simote.service.SecurityService;
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
	
	@ModelAttribute("awards")
	private List<Award> getAwards() {
		return awardService.sortAwardsByAwardedTime( securityService.getLoggedInUser().getAwards() );
	}
	
	@RequestMapping( method = RequestMethod.GET )
	public String get( Model model ) {
		User user = securityService.getLoggedInUser();
		
		Logger.getLogger(getClass()).warn("--" + user);
		Logger.getLogger(getClass()).warn("00--" + user.getCreatives());
		
		model.addAttribute( "user", user );
		model.addAttribute( "creatives", user.getCreatives() == null ? new HashSet<Creative>() : user.getCreatives() );
		user.getCreatives().size();
		
		return "personal/personal";
	}
		
}
