package org.simote.service.impl;

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

}
