package com.game.PlayerDatabase.web;


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

import com.game.PlayerDatabase.domain.ServerComputer;
import com.game.PlayerDatabase.domain.ServerComputerRepository;
import com.game.PlayerDatabase.domain.ServerRepository;

import jakarta.validation.Valid;

@Controller
public class ServerComputerController {

	//Adding repositories
	
	@Autowired
	private ServerComputerRepository screpository;
	
	@Autowired
	private ServerRepository srepository;
	
	
	
	//Show all server computers
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@RequestMapping("/servercomputerlist")
	public String Serverlist(Model model) {
		model.addAttribute("servercomputers", screpository.findAll());
		return "servercomputerlist";
	}
	
	//adding new server computer to the database
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@RequestMapping (value="/addservercomputer")
	public String addServer(Model model) {
		model.addAttribute("servercomputer", new ServerComputer());
		model.addAttribute("servercomputers", screpository.findAll());
		model.addAttribute("servers", srepository.findAll());
		return "addservercomputer";
	}
	
	//save the server computer with validation error
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@PostMapping("/saveServerComputer")
	public String save(@Valid @ModelAttribute ("servercomputer") ServerComputer servercomputer, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			System.out.println("Validation error has happened, please recheck.");
			model.addAttribute("servercomputers", screpository.findAll());
			model.addAttribute("servers", srepository.findAll());
			return "addservercomputer";
		}
		screpository.save(servercomputer);
		return "redirect:servercomputerlist";
	}
	
	//delete the server computer
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@GetMapping("/deleteServerComputer/{id}")
	public String deleteServerComputer(@PathVariable("id") Long serverComputerId, Model model) {
	    screpository.deleteById(serverComputerId);
	    return "redirect:../servercomputerlist";
	}
	
	// Edit the server computer function
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@GetMapping("/editServerComputer/{id}")
	public String editServerComputer(@PathVariable("id") Long serverComputerId, Model model) {
	    ServerComputer servercomputer = screpository.findById(serverComputerId).orElse(null);
	    model.addAttribute("servercomputer", servercomputer);
	    model.addAttribute("servers", srepository.findAll());
	    return "editservercomputer";
	}
	
	
}
