package org.sinrel.simote.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.sinrel.simote.domain.user.Language;
import org.sinrel.simote.domain.user.Theme;
import org.sinrel.simote.domain.user.UserSettings;
import org.sinrel.simote.form.SettingsForm;
import org.sinrel.simote.repository.UserSettingsRepository;
import org.sinrel.simote.service.SecurityService;
import org.sinrel.simote.service.SettingsService;
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
	
	@Autowired
	private UserSettingsRepository userSettingsRepository;
	
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
		        		
		String currentLangCode = settingsForm.getLang();
		Language currentLang = null;
		List<Language> languages = settingsService.getAllAvailableLanguages();
		for( Language lang : languages ) {
			if( lang.getCode().equals( currentLangCode ) ) {
				currentLang = lang;
				break;
			}
		}
		languages.remove(currentLang);
		
		model.addAttribute( "currentLang", currentLang );
		model.addAttribute( "siteLanguages", languages );
		
		
		UserSettings userSettings = securityService.getLoggedInUser().getUserSettings();
		
		userSettings.setTheme(currentTheme);
		userSettings.setLanguage(currentLang);
		
		userSettingsRepository.saveAndFlush( userSettings );
		
		settingsService.updateUserSettings( securityService.getLoggedInUser(), settingsForm);
		
		
        if ( bindingResult.hasErrors() ) {
        	return "personal/settings";
        }
        
       // return "personal/settings";

        //save settings
        return "redirect:../";
	}
	
}
