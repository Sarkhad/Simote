package org.sinrel.simote.repository;

import org.sinrel.simote.domain.user.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long>{

}
