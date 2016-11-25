package org.simote.controller;

import org.simote.domain.user.User;
import org.simote.repository.UserRepository;
import org.simote.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserProfileController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private SecurityService securityService;
	
	@GetMapping("/user/")
	public String get() {
		if( securityService.findLoggedInUsername() == null ) return "redirect:/";	
		return "redirect:/personal";
	}
	 
	@GetMapping( value = "/user/{nickname}" )
	public String getUserProfile( Model model, @PathVariable(required = true) String nickname ) {
		User requestedUser = userRepository.findByNickname( nickname );

		if( requestedUser == null ){
			return "personal/profileNotFound";
		}
		
		model.addAttribute( "requestedUser", requestedUser );
		model.addAttribute( "awards", requestedUser.getAwards() );
		model.addAttribute( "creatives", requestedUser.getCreatives() );
				
		return "personal/profile"; 
	}
	
}
