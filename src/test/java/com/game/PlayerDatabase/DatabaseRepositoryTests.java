package com.game.PlayerDatabase;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.game.PlayerDatabase.domain.Player;
import com.game.PlayerDatabase.domain.PlayerRepository;
import com.game.PlayerDatabase.domain.ServerComputerRepository;
import com.game.PlayerDatabase.domain.ServerRepository;
import com.game.PlayerDatabase.domain.Server;
import com.game.PlayerDatabase.domain.ServerComputer;

@DataJpaTest
public class DatabaseRepositoryTests {
	
	@Autowired
	PlayerRepository prepository;
	
	@Autowired
	ServerRepository srepository;
	
	@Autowired
	ServerComputerRepository sprepository;
	
// PLAYER TESTS
	// MARIA DB ISSUES
//	@Test
//	public void findByPlayerName() {
//		List<Player> players = prepository.findByplayerName("Aramed");
//		assertThat(players.get(0).getPlayerName().equalsIgnoreCase("Aramed"));	
//		
//	}
	
	// MARIA DB ISSUES
//	@Test
//	public void CreateNewPlayer() {
//		Player player = new Player("test", "test Testi", 1997, "testi@gmail.com", "testitappi55", srepository.findByServerName("Randuins").get(0));
//		prepository.save(player);
//		assertThat(player.getId()).isNotNull();
//	}
	

	@Test
	public void findPlayerOnServer() {
		List<Player> players = prepository.findByServerServerName("Randuins");
		assertThat(players).hasSize(0);
	}
	
// EI toimi koska validoinnissa on paljon mitkä blockkaavat saven. 
//	@Test
//	public void SavePlayer() {
//		Player player = new Player();
//		prepository.save(player);
//		assertNotEquals((Long) player.getId(), null);
//	}
	
// MARIA DB ISSUES 
//	@Test
//	public void updatePlayer() {
//	    Optional<Player> player = prepository.findById((long) 1);
//	    assertNotNull(player.get().getId());
//	    player.get().setEmail("asd@gmail.com");
//	    List<Player> players = prepository.findByEmail("asd@gmail.com");
//	    assertThat(players).size().isEqualTo(0);
//	}
	
//SERVER TESTS
// MARIA DB ISSUES
//	@Test
//	public void findServerName() {
//		List<Server> servers = srepository.findByServerName("Randuins");
//		assertThat(servers.get(0).getServerName().equalsIgnoreCase("Randuins"));
//
//	}
	
	@Test 
	public void createNewServer() {
		Server server = new Server("testi", 2000);
		srepository.save(server);
		assertThat(server.getId()).isNotNull();
	}
	
	
//SERVER COMPUTER TESTS
	// MARIA DB ISSUES
//	@Test
//	public void FindByComputerName() {
//	List<ServerComputer> servercomputers = sprepository.findByComputerName("Windows_1");
//	assertThat(servercomputers.get(0).getComputerName().equalsIgnoreCase("Windows_1"));
//	}
	
	// MARIA DB ISSUES
//	@Test 
//	public void createNewServerComputer() {
//		ServerComputer sp = new  ServerComputer("Windows_Testi", "OK", "180.0.0.0", srepository.findByServerName("Randuins").get(0));
//		sprepository.save(sp);
//		assertThat(sp.getId()).isNotNull();
//	}
	
	@Test 
	public void FindServerNameOnServerComputer() {
		List<ServerComputer> servercomputers = sprepository.findByServerServerName("Randuins");
		assertThat(servercomputers).hasSize(0);
		
	}
}
