package org.simote.repository;

import java.util.List;

import org.simote.domain.content.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Integer>{
	
	List<Tag> findFirst5StartsWithOrderByName( String name );
	
}
