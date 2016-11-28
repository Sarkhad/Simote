package org.sinrel.simote.repository;

import org.sinrel.simote.domain.user.UserSettings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSettingsRepository extends JpaRepository< UserSettings, Long>{

}
