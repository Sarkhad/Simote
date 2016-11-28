package org.sinrel.simote;

import java.security.Principal;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sinrel.simote.domain.user.User;
import org.sinrel.simote.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.i18n.AbstractLocaleResolver;

public class LocaleResolver extends AbstractLocaleResolver {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Locale resolveLocale(HttpServletRequest request) {
		Principal principal = request.getUserPrincipal();
		if( principal == null ) return new Locale( "en" );
		User user = userRepository.findByNickname(principal.getName());
	
		return new Locale( user.getUserSettings().getLanguage().getCode() );
	}

	@Override
	public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {}

}
