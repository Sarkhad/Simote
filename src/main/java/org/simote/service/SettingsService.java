package org.simote.service;

import java.util.List;

import org.simote.domain.user.Language;
import org.simote.domain.user.Theme;
import org.simote.form.SettingsForm;

public interface SettingsService {

	SettingsForm getSettingsForm();
	
	List<Theme> getAllAvailableThemes();
	
	List<Language> getAllAvailableLanguages();
	
}
