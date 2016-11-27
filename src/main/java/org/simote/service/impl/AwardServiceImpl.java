package org.simote.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.simote.domain.content.Award;
import org.simote.service.AwardService;
import org.simote.service.AwardType;
import org.springframework.stereotype.Service;

@Service
public class AwardServiceImpl implements AwardService {

	@Override
	public Award getAward(AwardType type) {
		return new Award( type );
	}
	
	public List<Award> sortAwardsByAwardedTime( Set<Award> awardsToSort ) {
		ArrayList<Award> awards = new ArrayList<Award>( awardsToSort );
		
		Collections.sort( awards, new Comparator<Award>(){
			public int compare(Award o1, Award o2) {
				if( o1.getAwardedTimestamp().after( o2.getAwardedTimestamp() ) ) return 1; else return -1;
			}
		});
		return awards;
	}

}
