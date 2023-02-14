package com.game.PlayerDatabase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.game.PlayerDatabase.domain.Player;
import com.game.PlayerDatabase.domain.PlayerRepository;
import com.game.PlayerDatabase.domain.Server;
import com.game.PlayerDatabase.domain.ServerComputer;
import com.game.PlayerDatabase.domain.ServerComputerRepository;
import com.game.PlayerDatabase.domain.ServerRepository;




@SpringBootApplication
public class PlayerDatabaseApplication {
	private static final Logger log = LoggerFactory.getLogger(PlayerDatabaseApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(PlayerDatabaseApplication.class, args);
	}

	
	
	@Bean
	public CommandLineRunner  demoData(PlayerRepository prepository, ServerRepository srepository, ServerComputerRepository screpository) {
		return (args) -> {
	
			//server computers to the database 
			log.info("Save servercomputers to the serverlist");
			//IMPLEMENTING TEST
			screpository.save(new ServerComputer("asd", "asd", "asd"));
			
			
			//servers to the database itself
			log.info("Save servers to the serverlist");
			
			srepository.save(new Server("Randuins"));
			srepository.save(new Server("Albama"));
			srepository.save(new Server("The Crocket"));
			srepository.save(new Server("Mindgard"));
			srepository.save(new Server("Ragnaros"));
			
			//Save players to the database
			log.info("Save players  to the server");
			
			prepository.save(new Player("Aramed", "Leo Heikkinen", 1997, "leoheik@gmail.com", "tervevaan55", srepository.findByServerName("Randuins").get(0)));
			prepository.save(new Player("Decker", "Jouni Ekon", 2000, "jouniekon@gmail.com", "CamelCase66", srepository.findByServerName("Albama").get(0)));
			prepository.save(new Player("Armedguy", "Teemu selan", 1987, "gameing565@gmail.com", "ThEePiC761", srepository.findByServerName("Mindgard").get(0)));
			prepository.save(new Player("Iconic53", "Pete Parkens", 1992, "petepark@gmail.com", "petepark1992", srepository.findByServerName("Mindgard").get(0)));
			prepository.save(new Player("TheGates", "Eckberg Sandel", 1990, "eckkergeggers@gmail.com", "Erkkionparas123", srepository.findByServerName("The Crocket").get(0)));
			prepository.save(new Player("Hetus", "Manu Teeru", 2002, "sillymyy6@gmail.com", "ThemindBlow44", srepository.findByServerName("Ragnaros").get(0)));
			prepository.save(new Player("Sufule", "Sulkka Pulkka", 1990, "textanddrive@gmail.com", "SickBoi353", srepository.findByServerName("Ragnaros").get(0)));
			prepository.save(new Player("ArcEnemy", "Erk Herb", 1999, "erbge@gmail.com", "Thesetters99", srepository.findByServerName("Ragnaros").get(0)));
			
			log.info("Fetch all players");
			for (Player player: prepository.findAll( )) {
				log.info(player.toString());
			}
		};
	}
}
