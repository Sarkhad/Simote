package org.simote.repository;

import org.simote.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
    User findByNickname( String nickname );
    
    User findByEmail( String email );
	
}
