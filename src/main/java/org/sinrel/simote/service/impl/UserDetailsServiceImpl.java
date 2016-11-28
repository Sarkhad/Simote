package org.sinrel.simote.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.sinrel.simote.domain.user.Role;
import org.sinrel.simote.domain.user.User;
import org.sinrel.simote.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) {
		User user;

		if( !isEmail( username ) ) {
			user = userRepository.findByNickname(username);
		}else{
			user = userRepository.findByEmail( username );
		}
		
        if( user == null ) throw new UsernameNotFoundException("No user in repository");
         
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for ( Role role : user.getRoles() ){
            grantedAuthorities.add(new SimpleGrantedAuthority( role.getName() ) );
        }
                
        org.sinrel.simote.service.impl.UserDetails details = new org.sinrel.simote.service.impl.UserDetails( user.getNickname(), user.getPassword(), true, true, true, !user.isBanned(), grantedAuthorities);//new org.simote.service.impl.UserDetails(user.getNickname(), user.getPassword(), enabled, accountNonExpired, credential , grantedAuthorities);
        details.setUser(user);
        
        return details;
   }
	
	boolean isEmail( String email ) {
		if( email.split("@").length == 1 )  return false;
		return true;
	}
	
}
