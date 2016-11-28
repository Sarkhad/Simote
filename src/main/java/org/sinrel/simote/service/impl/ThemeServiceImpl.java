package org.sinrel.simote.service.impl;

import org.sinrel.simote.service.ThemeService;
import org.springframework.stereotype.Service;

@Service
public class ThemeServiceImpl implements ThemeService {

	public String getDefaultThemeName() {
		return "light";
	}
	
}
