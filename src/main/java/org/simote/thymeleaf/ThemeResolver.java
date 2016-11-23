package org.simote.thymeleaf;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.simote.domain.user.User;
import org.simote.repository.UserRepository;
import org.simote.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.theme.AbstractThemeResolver;

public class ThemeResolver extends AbstractThemeResolver {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ThemeService themeService;
	
	@Transactional
	public String resolveThemeName( HttpServletRequest request ) {
		/*
		Cookie[] cs = request.getCookies();
		if( cs == null  ) return themeService.getDefaultThemeName();
		
		for( Cookie c : cs ) {
			if( c.getName().equals("theme") ) {
				return c.getValue();
			}
		} 
		*/
		Principal principal = request.getUserPrincipal();
		
		if( principal == null ) return themeService.getDefaultThemeName();
	
		User user = userRepository.findByNickname(principal.getName());
		
		//Cookie foo = new Cookie("theme", user.getUserSettings().getTheme().getCode() ); 
		
		
		return user.getUserSettings().getTheme().getCode(); //TODO remade on cookies*/
	}
	
	@Override
	public void setThemeName(HttpServletRequest request, HttpServletResponse response, String themeName) {
	}
	
}
