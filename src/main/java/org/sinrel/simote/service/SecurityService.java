package org.sinrel.simote.service;

import org.sinrel.simote.domain.user.User;

public interface SecurityService {
	
    String findLoggedInUsername();

    User getLoggedInUser();
    
    void authorize( String username, String password );
    
    boolean hasRole(String role);
    
}
