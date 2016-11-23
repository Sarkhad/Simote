package org.simote.service.impl;

import org.simote.service.ThemeService;
import org.springframework.stereotype.Service;

@Service
public class ThemeServiceImpl implements ThemeService {

	public String getDefaultThemeName() {
		return "light";
	}
	
}
