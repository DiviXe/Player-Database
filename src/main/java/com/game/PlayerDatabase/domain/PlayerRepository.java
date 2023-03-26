package com.game.PlayerDatabase.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface PlayerRepository extends CrudRepository<Player, Long> {
	List<Player> findByplayerName(String playerName);
	List<Player> findByEmail(String email);
	List<Player> findByServerServerName(String string);
}
