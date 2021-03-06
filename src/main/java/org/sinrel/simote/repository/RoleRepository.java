package org.sinrel.simote.repository;

import org.sinrel.simote.domain.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	
	Role findByName( String name );
	
}
