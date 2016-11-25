package org.simote.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.simote.domain.user.Language;
import org.simote.domain.user.Theme;
import org.simote.form.SettingsForm;
import org.simote.service.SecurityService;
import org.simote.service.SettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping( value = "personal/settings" )
public class SettingsController {

	@Autowired
	private SettingsService settingsService;
	
	@Autowired
	private SecurityService securityService;
	
	@GetMapping
	public String getSettingsPage( Model model ) {
		Theme currentTheme = securityService.getLoggedInUser().getUserSettings().getTheme();
		List<Theme>	themes = settingsService.getAllAvailableThemes();
		themes.remove(currentTheme);
		
		Language currentLanguage = securityService.getLoggedInUser().getUserSettings().getLanguage();
		List<Language> languages = settingsService.getAllAvailableLanguages();
		languages.remove(currentLanguage);
		
		model.addAttribute( "currentTheme", currentTheme );
		model.addAttribute( "currentLang", currentLanguage );
		
		model.addAttribute( "settingsForm", settingsService.getSettingsForm() );
		model.addAttribute( "siteThemes", themes );
		model.addAttribute( "siteLanguages", languages );
		
		return "personal/settings";
	}
	
	
	@PostMapping
	public String registration( @ModelAttribute("settingsForm") SettingsForm settingsForm, BindingResult bindingResult, Model model ) {
		Logger.getLogger(getClass()).warn( settingsForm.getLang() );
		
		String currentThemeCode = settingsForm.getTheme();
		Theme currentTheme = null;
		List<Theme>	themes = settingsService.getAllAvailableThemes();
		for( Theme theme : themes ) {
			Logger.getLogger(getClass()).warn(theme.getCode());
			if( theme.getCode().equals( currentThemeCode ) ) {
				currentTheme = theme;
				Logger.getLogger(getClass()).warn("true");
				break;
			}
		}
		themes.remove(currentTheme);
		
		model.addAttribute( "currentTheme", currentTheme );
		model.addAttribute( "siteThemes", themes );
		
		/*
		String currentLangCode = settingsForm.getTheme();
		Language currentLang = null;
		List<Language> languages = settingsService.getAllAvailableLanguages();
		for( Language language : languages ) {
			Logger.getLogger(getClass()).warn(language.getCode());
			if( language.getCode().equals( currentLangCode ) ) {
				currentLang = language;
				Logger.getLogger(getClass()).warn("true");
				break;
			}
		}
		languages.remove(currentLang);
		

		model.addAttribute( "currentLang", currentLang );
		model.addAttribute( "siteLanguages", languages );
		*/
		//settingsFormValidator.validate( settingsForm, bindingResult );
        
		securityService.getLoggedInUser().getUserSettings().setTheme(currentTheme);
		
        if (true) { //bindingResult.hasErrors()
            return "personal/settings";
        }

        //save settings
        
		return "redirect:../";
	}
	
}
