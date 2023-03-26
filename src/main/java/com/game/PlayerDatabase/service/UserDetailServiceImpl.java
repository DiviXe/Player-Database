package com.game.PlayerDatabase.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Service;

import com.game.PlayerDatabase.domain.PlayerDatabaseUser;
import com.game.PlayerDatabase.domain.PlayerDatabaseUserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	private static final Logger log = LoggerFactory.getLogger(UserDetailServiceImpl.class);
	private final PlayerDatabaseUserRepository repository;
	
@Autowired
public UserDetailServiceImpl(PlayerDatabaseUserRepository playerDatabaseUserRepository) {
		this.repository = playerDatabaseUserRepository;

}

@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	log.info("loadUserByUsername: " + username);
	
	PlayerDatabaseUser curruser = repository.findByUsername(username);
	
	//returning null is user is not found 
	UserBuilder builder = null;
	if (curruser == null) {
    	throw new UsernameNotFoundException("User not found.");
	}
	else {
    	log.info("User found: " + curruser.getUsername() + ", Role: " + curruser.getRole());
    	builder = org.springframework.security.core.userdetails.User.withUsername(username);
    	builder.password(curruser.getPasswordHash());
    	builder.roles(curruser.getRole()); 
	}
	
    return builder.build();
}
}
