package org.sinrel.simote.service;

import java.util.List;
import java.util.Set;

import org.sinrel.simote.domain.content.Creative;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CreativeService {
	
	Creative getCreative( int id );
	
	List<Creative> sortCreativesByCreated( Set<Creative> creativesToSort );

	List<Creative> sortCreativesByCreatedDesc(Set<Creative> creatives);
	
	Page<Creative> findAllByOrderByCreatedDesc( Pageable pageable );

	Page<Creative> findAllByOrderByEditedDesc(Pageable pageable);
	
}