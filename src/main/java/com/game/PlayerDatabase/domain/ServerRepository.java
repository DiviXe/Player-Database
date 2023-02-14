package com.game.PlayerDatabase.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ServerRepository extends CrudRepository<Server, Long> {
	
	List<Server> findByServerName(String serverName);
}
