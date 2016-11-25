package org.simote.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.simote.domain.user.Language;
import org.simote.domain.user.Theme;
import org.simote.domain.user.User;
import org.simote.form.SettingsForm;
import org.simote.repository.LanguageRepository;
import org.simote.repository.ThemeRepository;
import org.simote.repository.UserRepository;
import org.simote.service.SecurityService;
import org.simote.service.SettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SettingsServiceImpl implements SettingsService {

	@Autowired
	private SecurityService securityService;
	
	@Autowired
	private UserRepository userRepository; 
	
	@Autowired
	private ThemeRepository themeRepository;
	
	@Autowired
	private LanguageRepository languageRepository;
	
	@Override
	public SettingsForm getSettingsForm() {
		SettingsForm form = new SettingsForm();
		
		User user = userRepository.findByNickname( securityService.findLoggedInUsername() );

		form.setEmail( user.getEmail() );
		form.setFirstName( user.getFirstName() );
		form.setLastName( user.getLastName() );
		form.setNickname( user.getNickname() );
		
		return form;
	}

	@Override
	@Transactional
	public List<Theme> getAllAvailableThemes() {
		return themeRepository.findAll();
	}

	@Override
	@Transactional
	public List<Language> getAllAvailableLanguages() {
		return languageRepository.findAll();
	}
	
	
	
	
}
