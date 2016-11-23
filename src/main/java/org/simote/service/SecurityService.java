package org.simote.service;

import org.simote.domain.user.User;

public interface SecurityService {
	
    String findLoggedInUsername();

    User getLoggedInUser();
    
    void authorize( String username, String password );
    
    boolean hasRole(String role);
    
}
