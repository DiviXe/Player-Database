package com.game.PlayerDatabase.web;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	@RequestMapping (value="/add")
	public String addPlayer(Model model) {
		model.addAttribute("player", new Player());
		model.addAttribute("servers", srepository.findAll());
		return "addplayer";
	}
	
	//save the player with validation error
	@PostMapping("/save")
	public String save(@Valid @ModelAttribute ("player") Player player, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			System.out.println("Validation error has happened, please recheck.");
			model.addAttribute("servers", srepository.findAll());
			return "addplayer";
		}
		prepository.save(player);
		return "redirect:playerlist";
	}
	
	//delete the player function 
	@GetMapping("/deletePlayer/{id}")
	public String deletePlayer(@PathVariable("id") Long playerId, Model model) {
		prepository.deleteById(playerId);
		return "redirect:../playerlist";
	}
	
	// Edit the player function
    @GetMapping("/editPlayer/{id}")
    public String editPlayer(@PathVariable("id") Long playerId, Model model) {
    	model.addAttribute("player", prepository.findById(playerId));
    	model.addAttribute("servers", srepository.findAll());
    	return "editplayer";
    }   
	
	
	
}
