package com.game.PlayerDatabase.domain;

import org.springframework.data.repository.CrudRepository;

public interface PlayerDatabaseUserRepository extends CrudRepository <PlayerDatabaseUser, Long> {

	PlayerDatabaseUser findByUsername(String username);
	PlayerDatabaseUser findByFirstName(String FirstName);
	
}
