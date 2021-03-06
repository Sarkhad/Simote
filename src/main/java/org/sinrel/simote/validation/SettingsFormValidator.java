package org.sinrel.simote.validation;

import org.sinrel.simote.domain.user.User;
import org.sinrel.simote.form.SettingsForm;
import org.sinrel.simote.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class SettingsFormValidator implements Validator {
	
    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        SettingsForm form = (SettingsForm) o;
		
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "page.registration.signupform.validation.empty.firstname");
        if (form.getFirstName().length() < 2 || form.getFirstName().length() > 50 ) {
            errors.rejectValue("firstName", "page.registration.signupform.validation.size.firstname");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "page.registration.signupform.validation.empty.lastname");
        if (form.getFirstName().length() < 2 || form.getFirstName().length() > 50 ) {
            errors.rejectValue("lastName", "page.registration.signupform.validation.size.lastname");
        }
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nickname", "page.registration.signupform.validation.empty.nickname");
        if ( userService.findByNickname( form.getNickname() ) != null ) {
            errors.rejectValue("nickname", "page.registration.signupform.validation.duplicate.nickname");
        }
        if (form.getNickname().length() < 6 || form.getNickname().length() > 50 ) {
            errors.rejectValue("password", "page.registration.signupform.validation.size.nickname");
        }
        
        /*
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "page.registration.signupform.validation.empty.password");
        if ( form.getPassword().length() < 6 || form.getPassword().length() > 100 ) {
            errors.rejectValue("password", "page.registration.signupform.validation.size.password");
        }
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwordConfirm", "page.registration.signupform.validation.empty.passwordconfirm");
        if ( form.getPassword().length() < 6 || form.getPassword().length() > 100 ) {
            errors.rejectValue("passwordConfirm", "page.registration.signupform.validation.size.passwordconfirm");
        }
        
        if ( !form.getPassword().equals( form.getPasswordConfirm() ) ) {
            errors.rejectValue("passwordConfirm", "page.registration.signupform.validation.nodiff.passwordconfirm");
        }
        */
       
    }
        
}
