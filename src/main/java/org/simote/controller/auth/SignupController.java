package org.simote.controller.auth;

import org.simote.form.SignupForm;
import org.simote.service.SecurityService;
import org.simote.service.UserService;
import org.simote.validation.RegistrationFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping( value = "auth/signup" )
public class SignupController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private SecurityService securityService;
	
	@Autowired
	private RegistrationFormValidator registrationValidator;
	
	@GetMapping
	public String registration( Model model ) {
		model.addAttribute( "signupForm", new SignupForm() );
		
		return "auth/signup";
	}	
	
	@PostMapping
	public String registration( @ModelAttribute("signupForm") SignupForm signupForm, BindingResult bindingResult, Model model ) {
        registrationValidator.validate( signupForm, bindingResult );
        
        if (bindingResult.hasErrors()) {
            return "auth/signup";
        }

        userService.register( signupForm.getUser() );
        securityService.authorize( signupForm.getNickname(), signupForm.getPasswordConfirm() );
        
		return "redirect:signup/welcome";
	}
	
    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome() {
        return "auth/signup/welcome";
    }
	
}
