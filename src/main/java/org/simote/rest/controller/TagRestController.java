package org.simote.rest.controller;

import java.util.List;
import org.simote.domain.content.Tag;
import org.simote.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController( "tags" )
public class TagRestController {

	@Autowired
	private TagRepository tagRepository;
	
	@GetMapping( "/autocomplete" ) 
	private List<Tag> tagAutocomplete( @Param( "base" ) String base ) {
		return tagRepository.findFirst5StartsWithOrderByName( base );
	}
	
}
