package org.simote.service;

import org.simote.domain.content.Award;

public interface AwardService {
	
	Award getAward( AwardType type );
	
}
