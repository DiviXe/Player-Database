package com.game.PlayerDatabase.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ServerComputerRepository extends CrudRepository<ServerComputer, Long> {
	List<ServerComputer> findByComputerName(String computerName);
	
}
