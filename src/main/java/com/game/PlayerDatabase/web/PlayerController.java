package com.game.PlayerDatabase.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.game.PlayerDatabase.domain.Player;
import com.game.PlayerDatabase.domain.PlayerRepository;
import com.game.PlayerDatabase.domain.Server;
import com.game.PlayerDatabase.domain.ServerComputerRepository;
import com.game.PlayerDatabase.domain.ServerRepository;

@Controller
public class PlayerController {

	//Adding repositories
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
	
	//Player by ID REST
	@GetMapping("/player/{id}")
	public @ResponseBody Optional<Player> findPlayerRest(@PathVariable("id") Long playerId) {
		return prepository.findById(playerId);
	}
	
	
	//Show all players
	@RequestMapping("/playerlist")
	public String PlayerList(Model model) {
		model.addAttribute("players", prepository.findAll());
		return "playerlist";
	}
	
	//adding player to the database
	@RequestMapping (value="/add")
	public String addPlayer(Model model) {
		model.addAttribute("player", new Player());
		model.addAttribute("servers", srepository.findAll());
		model.addAttribute("servercomputers", screpository.findAll());
		return "addplayer";
	}
	
	//save the player
	@PostMapping("/save")
	public String savePlayer(Player player) {
		prepository.save(player);
		return "redirect:playerlist";
	}
	//delete the player function 
	@GetMapping("/delete/{id}")
	public String deletePlayer(@PathVariable("id") Long playerId, Model model) {
		prepository.deleteById(playerId);
		return "redirect:../playerlist";
	}
	
	// Edit the player function
    @GetMapping("/edit/{id}")
    public String editPalyer(@PathVariable("id") Long playerId, Model model) {
    	model.addAttribute("player", prepository.findById(playerId));
    	model.addAttribute("servers", srepository.findAll());
    	return "editplayer";
    }   
	
	
	
}
