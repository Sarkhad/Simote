package org.simote.service;

import java.util.List;
import java.util.Set;

import org.simote.domain.content.Award;

public interface AwardService {
	
	Award getAward( AwardType type );
	
	List<Award> sortAwardsByAwardedTime( Set<Award> awardsToSort );
	
}
