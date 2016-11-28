package org.sinrel.simote.repository;

import org.sinrel.simote.domain.content.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChapterRepository extends JpaRepository<Chapter, Integer> {

}
