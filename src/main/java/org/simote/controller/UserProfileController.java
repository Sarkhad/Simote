package org.simote.controller;

import org.simote.domain.user.User;
import org.simote.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserProfileController {

	@Autowired
	private UserRepository userRepository;
	
	//@RequestMapping
	public String get() {
		return "profile";
	}
	 
	@RequestMapping( value = "/user/{nickname}" )
	public String getUserProfile( Model model, @PathVariable(required = true) String nickname ) {
		User requestedUser = userRepository.findByNickname( nickname );
		
		model.addAttribute( "requestedUser", requestedUser );
		
		return "personal/profile"; 
	}
	
}
