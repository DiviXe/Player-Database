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
	
			
			//servers to the database itself
			log.info("Save servers to the serverlist only admin can access servers and add new ones");
			
			srepository.save(new Server("Randuins", 2000));
			srepository.save(new Server("Albama", 1500));
			srepository.save(new Server("The Crocket", 1300));
			srepository.save(new Server("Mindgard", 1700));
			srepository.save(new Server("Ragnaros", 2000));
			
			//IMPLEMENTING Server computers
			screpository.save(new ServerComputer("Windows_1", "OK", "198.5.56.43", srepository.findByServerName("Randuins").get(0)));
			screpository.save(new ServerComputer("Windows_2", "OK", "208.64.53.102", srepository.findByServerName("Ragnaros").get(0)));
			screpository.save(new ServerComputer("Windows_3", "OK", "198.64.21.54", srepository.findByServerName("Mindgard").get(0)));
			screpository.save(new ServerComputer("Windows_4", "OK", "198.43.78.65", srepository.findByServerName("The Crocket").get(0)));
			screpository.save(new ServerComputer("Windows_5", "OK", "152.42.67.64", srepository.findByServerName("Albama").get(0)));
			screpository.save(new ServerComputer("Windows_6", "OK_BACKUP_PC", "151.64.63.123", srepository.findByServerName("Ragnaros").get(0)));
			screpository.save(new ServerComputer("Windows_7", "OK_BACKUP_PC", "198.20.52.50", srepository.findByServerName("Mindgard").get(0)));
			 
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
			
			log.info("Fetch all servers");
			for (Server server: srepository.findAll( )) {
				log.info(server.toString());
			}
			
			log.info("Fetch all Server computers");
			for (ServerComputer servercomputer: screpository.findAll( )) {
				log.info(servercomputer.toString());
			}
		};
	}
}
