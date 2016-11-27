package org.simote.service.impl;

import org.simote.domain.content.Creative;
import org.simote.repository.CreativeRepository;
import org.simote.service.CreativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class CreativeServiceImpl implements CreativeService {

	@Autowired
	private CreativeRepository creativeRepository; 
	
	
	public Creative getCreative(int id) {
		return creativeRepository.findOne(id);
	}

}
