package org.sinrel.simote.repository;

import org.sinrel.simote.domain.content.Award;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AwardRepository extends JpaRepository<Award, Long>{
	
}
