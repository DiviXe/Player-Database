package com.game.PlayerDatabase.web;

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

import com.game.PlayerDatabase.domain.Server;
import com.game.PlayerDatabase.domain.ServerComputerRepository;
import com.game.PlayerDatabase.domain.ServerRepository;

import jakarta.validation.Valid;

@Controller
public class ServerController {
	private static final Logger log = LoggerFactory.getLogger(PlayerController.class);

	//Adding repositories
	
	@Autowired
	private ServerRepository srepository;
	
	@Autowired
	private ServerComputerRepository screpository;
	
	
	
	//Show all servers
	@RequestMapping("/serverlist")
	public String Serverlist(Model model) {
		model.addAttribute("servers", srepository.findAll());
		model.addAttribute("servercomputers", screpository.findAll());
		return "serverlist";
	}
	
	//adding new server to the database
	@RequestMapping (value="/addserver")
	public String addServer(Model model) {
		model.addAttribute("server", new Server());
		model.addAttribute("servercomputers", screpository.findAll());
		return "addserver";
	}
	
	//save the server with validation error
	@PostMapping("/saveServer")
	public String save(@Valid @ModelAttribute ("server") Server server, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			System.out.println("Validation error has happened, please recheck.");
			model.addAttribute("servercomputers", screpository.findAll());
			return "addserver";
		}
		srepository.save(server);
		return "redirect:serverlist";
	}
	
	//delete the server function 
	@GetMapping("/deleteServer/{id}")
	public String deleteServer(@PathVariable("id") Long serverId, Model model) {
	    srepository.deleteById(serverId);
	    return "redirect:../serverlist";
	}
	
	// Edit the server function
    @GetMapping("/editServer/{id}")
    public String editServer(@PathVariable("id") Long serverId, Model model) {
    	model.addAttribute("server", srepository.findById(serverId));
    	return "editserver";
    }   
	
	
	
}
