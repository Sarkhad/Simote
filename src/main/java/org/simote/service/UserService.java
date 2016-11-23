package org.simote.service;

import org.simote.domain.user.User;

public interface UserService {
	
	void register( User user );
	
    User findByNickname( String nickname );
    
    User findByEmail( String email );
	
}
