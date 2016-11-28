package org.sinrel.simote.service;

import java.util.List;
import java.util.Set;

import org.sinrel.simote.domain.content.Award;
import org.sinrel.simote.domain.user.User;

public interface AwardService {
	
	Award getAward( AwardType type );
	
	List<Award> sortAwardsByAwardedTime( Set<Award> awardsToSort );
	
	public Award giveUserAward( User user, AwardType type );
	
}
