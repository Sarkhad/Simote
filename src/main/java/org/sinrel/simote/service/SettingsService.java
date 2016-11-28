package org.sinrel.simote.service;

import java.util.List;

import org.sinrel.simote.domain.user.Language;
import org.sinrel.simote.domain.user.Theme;
import org.sinrel.simote.domain.user.User;
import org.sinrel.simote.form.SettingsForm;

public interface SettingsService {

	SettingsForm getSettingsForm();
	
	List<Theme> getAllAvailableThemes();
	
	List<Language> getAllAvailableLanguages();
	
	void updateUserSettings( User user, SettingsForm settingsForm );
	
}
