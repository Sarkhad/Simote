package org.simote.service.impl;

import java.util.Calendar;

import org.simote.domain.content.Award;
import org.simote.domain.user.User;
import org.simote.repository.AwardRepository;
import org.simote.repository.LanguageRepository;
import org.simote.repository.RoleRepository;
import org.simote.repository.ThemeRepository;
import org.simote.repository.UserRepository;
import org.simote.repository.UserSettingsRepository;
import org.simote.service.AwardService;
import org.simote.service.AwardType;
import org.simote.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private AwardService awardService;
	
	@Autowired
	private AwardRepository awardRepository;
	
	@Autowired
	private LanguageRepository languageRepository;
	
	@Autowired
	private ThemeRepository themeRepository;
	
	@Autowired
	private UserSettingsRepository userSettingsRepository;
	
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public void register( User user ) {
        user.setPassword( bCryptPasswordEncoder.encode( user.getPassword() ) );
          
        user.addRole( roleRepository.findByName("USER") );
        user.setRegistrationDate( new java.sql.Date(Calendar.getInstance().getTime().getTime() ) );
        
        Award award = awardService.getAward( AwardType.SUCCESSFUL_REGISTRATION );
        award.setAwarded( new java.sql.Date(Calendar.getInstance().getTime().getTime() ) );
        user.addAward( award );
        
        user.getUserSettings().setLanguage( languageRepository.findAll().get(0) );
        user.getUserSettings().setTheme( themeRepository.findAll().get(0) ); 
        
        awardRepository.saveAndFlush( award );
        userSettingsRepository.saveAndFlush( user.getUserSettings() );
        userRepository.saveAndFlush(user);
	}

	@Override
	public User findByNickname(String nickname) {
		return userRepository.findByNickname(nickname);
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	
	
}
