package com.game.PlayerDatabase.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.game.PlayerDatabase.domain.Player;
import com.game.PlayerDatabase.domain.PlayerRepository;
import com.game.PlayerDatabase.domain.Server;
import com.game.PlayerDatabase.domain.ServerComputer;
import com.game.PlayerDatabase.domain.ServerComputerRepository;
import com.game.PlayerDatabase.domain.ServerRepository;



@RestController
public class RestDatabaseController {
	
	@Autowired
	private PlayerRepository prepository;
	
	@Autowired
	private ServerRepository srepository;
	
	@Autowired
	private ServerComputerRepository screpository;

		
		//RESTful way to show all players
		@GetMapping("players")
		public @ResponseBody List<Player> playerListRest() {
			return (List<Player>) prepository.findAll();
		}
		
		//RESful way to see all servers
		@GetMapping("servers")
		public @ResponseBody List<Server> serverListRest() {
			return (List<Server>) srepository.findAll();
		}
		//RESful way to see all server computers
		@GetMapping("servercomputers")
		public @ResponseBody List<ServerComputer> serverComputerListRest() {
			return (List<ServerComputer>) screpository.findAll();
		}
		
		//Player by ID REST
		@GetMapping("/player/{id}")
		public @ResponseBody Optional<Player> findPlayerRest(@PathVariable("id") Long playerId) {
			return prepository.findById(playerId);
		}
		//Server by ID REST
		@GetMapping("/server/{id}")
		public @ResponseBody Optional<Server> findServerRest(@PathVariable("id") Long serverId) {
		return srepository.findById(serverId);
				}
				
	    //Servercomputer by ID REST
		@GetMapping("/servercomputer/{id}")
		public @ResponseBody Optional<ServerComputer> findServerComputerRest(@PathVariable("id") Long serverComputerId) {
		return screpository.findById(serverComputerId);
				}
		
		
		
}
