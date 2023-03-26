package com.game.PlayerDatabase.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.game.PlayerDatabase.domain.PlayerDatabaseUserRepository;
import com.game.PlayerDatabase.domain.SignUpForm;


@Controller
public class UserController {

	@Autowired
	private PlayerDatabaseUserRepository repository;
	
	@GetMapping(value= {"/", "index"})
	public String showMainPage(@AuthenticationPrincipal PlayerDatabaseUserRepository userRepository, Model model) {
	return "index";
	}
	
	@RequestMapping(value = "/signup")
    public String addStudent(Model model){
    	model.addAttribute("signupform", new SignUpForm());
        return "signup";
    }	
}
