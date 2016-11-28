package org.sinrel.simote.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.sinrel.simote.domain.content.Tag;
import org.sinrel.simote.repository.TagRepository;
import org.sinrel.simote.service.TagService;
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

	@Override
	public List<String> autocomplete(String name) {
		List<Tag> tags = tagRepository.findFirst5ByNameStartingWith(name);
		
		ArrayList<String> autocompleteSuggestions = new ArrayList<String>();
		
		tags.forEach( t -> autocompleteSuggestions.add( t.getName() )  );
		
		return autocompleteSuggestions;
	}
	
	
	
}
