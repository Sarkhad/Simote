package org.sinrel.simote.service;

import java.util.List;

import org.sinrel.simote.domain.content.Tag;

public interface TagService {

	List<Tag> getAllTags();
	
	List<String> autocomplete( String name );
	
}
