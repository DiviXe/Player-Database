package com.game.PlayerDatabase;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.game.PlayerDatabase.domain.Player;
import com.game.PlayerDatabase.domain.PlayerRepository;
import com.game.PlayerDatabase.domain.ServerComputerRepository;
import com.game.PlayerDatabase.domain.ServerRepository;
import com.game.PlayerDatabase.domain.Server;
import com.game.PlayerDatabase.domain.ServerComputer;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class DatabaseRepositoryTests {
	
	@Autowired
	PlayerRepository prepository;
	
	@Autowired
	ServerRepository srepository;
	
	@Autowired
	ServerComputerRepository sprepository;
	
// PLAYER TESTS
	@Test
	public void findByPlayerName() {
		List<Player> players = prepository.findByplayerName("Decker");
		assertThat(players.get(0).getPlayerName().equalsIgnoreCase("Decker"));	
		
	}
	
	@Test
	public void CreateNewPlayer() {
		Player player = new Player("testiii", "Testi Teppo", 1997, "testi123@gmail.com", "testitappi55", srepository.findByServerName("Randuins").get(0));
		prepository.save(player);
		assertThat(player.getId()).isNotNull();
	}
	

	@Test
	public void findPlayerOnServer() {
		List<Player> players = prepository.findByServerServerName("Albama");
		assertThat(players).hasSize(1);
	}
	

	@Test
	public void updatePlayer() {
	    Optional<Player> player = prepository.findById((long) 1);
	    assertNotNull(player.get().getId());
	    player.get().setEmail("asd@gmail.com");
	    List<Player> players = prepository.findByEmail("asd@gmail.com");
	    assertThat(players).size().isEqualTo(1);
	}
	
//SERVER TESTS
	@Test
	public void findServerName() {
		List<Server> servers = srepository.findByServerName("Randuins");
		assertThat(servers.get(0).getServerName().equalsIgnoreCase("Randuins"));

	}
	
	@Test
	public void updateServer() {
		Optional<Server> server = srepository.findById((long) 1);
		assertNotEquals(server.get().getId(), null);
		server.get().setServerName("testi123");
		List<Server> servers = srepository.findByServerName("testi123");
		assertThat(servers).hasSize(1);
	}
	
//SERVER COMPUTER TESTS
	@Test
	public void FindByComputerName() {
	List<ServerComputer> servercomputers = sprepository.findByComputerName("Windows_2");
	assertThat(servercomputers.get(0).getComputerName().equalsIgnoreCase("Windows_2"));
	}
	
	@Test 
	public void createNewServerComputer() {
		ServerComputer sp = new  ServerComputer("Windows_Test2", "OK_OK", "180.152.52.62", srepository.findByServerName("Albama").get(0));
		sprepository.save(sp);
		assertThat(sp.getId()).isNotNull();
	}
	
	@Test 
	public void FindServerNameOnServerComputer() {
		List<ServerComputer> servercomputers = sprepository.findByServerServerName("Albama");
		
		assertThat(servercomputers).size().isEqualTo(1);
	}
	
	@Test
	public void UpdateServerComputer() {
		Optional<ServerComputer> servercomputer = sprepository.findById((long) 1);
		assertNotEquals(servercomputer.get().getId(), null);
		servercomputer.get().setComputerName("test_computer1");
		List<ServerComputer> servercomputers = sprepository.findByComputerName("test_computer1");
		assertThat(servercomputers).hasSize(1);
		
	}
	
}
