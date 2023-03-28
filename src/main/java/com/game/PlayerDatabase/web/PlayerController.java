package com.game.PlayerDatabase.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.game.PlayerDatabase.domain.Player;
import com.game.PlayerDatabase.domain.PlayerRepository;
import com.game.PlayerDatabase.domain.ServerRepository;

import jakarta.validation.Valid;

@Controller
public class PlayerController {
	private static final Logger log = LoggerFactory.getLogger(PlayerController.class);

	//Adding repositories
	@Autowired
	private PlayerRepository prepository;
	
	@Autowired
	private ServerRepository srepository;
	
	
	//Show all players
	@RequestMapping("/playerlist")
	public String PlayerList(Model model) {
		model.addAttribute("players", prepository.findAll());
		return "playerlist";
	}
	
	//adding player to the database
	@RequestMapping (value="/addPlayer")
	public String addPlayer(Model model) {
		model.addAttribute("player", new Player());
		model.addAttribute("servers", srepository.findAll());
		return "addplayer";
	}
	
	//save the player with validation error
	@PostMapping("/savePlayer")
	public String save(@Valid @ModelAttribute ("player") Player player, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			System.out.println("There has been an error, please recheck the error message.");
			model.addAttribute("servers", srepository.findAll());
			return "addplayer";
		}
		prepository.save(player);
		return "redirect:playerlist";
	}
	
	//delete the player function 
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@GetMapping("/deletePlayer/{id}")
	public String deletePlayer(@PathVariable("id") Long playerId, Model model) {
		prepository.deleteById(playerId);
		return "redirect:../playerlist";
	}
	
	// Edit the player function
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/editPlayer/{id}")
    public String editPlayer(@PathVariable("id") Long playerId, Model model) {
    	model.addAttribute("editPlayer", prepository.findById(playerId));
    	model.addAttribute("servers", srepository.findAll());
    	return "editplayer";
    }   
	
	
	
}
