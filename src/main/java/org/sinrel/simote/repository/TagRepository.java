package org.sinrel.simote.repository;

import java.util.List;

import org.sinrel.simote.domain.content.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Integer>{
	
	List<Tag> findFirst5ByNameStartingWith( String name );

	List<Tag> findByName( String name );
	
}
