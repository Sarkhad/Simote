package org.simote.service.impl;

import java.util.List;

import org.simote.domain.content.Tag;
import org.simote.repository.TagRepository;
import org.simote.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl implements TagService {

	@Autowired
	private TagRepository tagRepository;
		
	@Override
	public List<Tag> getAllTags() {
		return tagRepository.findAll();
	}
	
	
	
}