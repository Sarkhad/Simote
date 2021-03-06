package org.sinrel.simote.repository;

import org.sinrel.simote.domain.content.Creative;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreativeRepository extends PagingAndSortingRepository<Creative, Integer> {	
	
	Page<Creative> findAllByOrderByCreatedDesc( Pageable pageable );

	Page<Creative> findAllByOrderByEditedDesc(Pageable pageable);

}
