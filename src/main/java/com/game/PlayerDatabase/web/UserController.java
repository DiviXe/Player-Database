package com.game.PlayerDatabase.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.game.PlayerDatabase.domain.PlayerDatabaseUser;
import com.game.PlayerDatabase.domain.PlayerDatabaseUserRepository;
import com.game.PlayerDatabase.domain.SignUpForm;

import jakarta.validation.Valid;


@Controller
public class UserController {
	private static final Logger log = LoggerFactory.getLogger(UserController.class);


	
	@Autowired
	private PlayerDatabaseUserRepository userRepository;
	
	@GetMapping(value= {"/", "index"})
	public String showMainPage(@AuthenticationPrincipal PlayerDatabaseUserRepository userRepository, Model model) {
	return "index";
	}
	
	@RequestMapping(value = "/signup")
    public String addNewPlayerDatabaseUser(Model model){
    	model.addAttribute("regularuser", new SignUpForm());
        return "signup";
    }	
	
	@PostMapping("/saveuser")
	public String saveUser(@Valid @ModelAttribute("regularuser") SignUpForm regularUser, BindingResult bindingResult) {
	    log.info("saveuser: newUser is " + regularUser.toString());
	    if (bindingResult.hasErrors()) { 
	        return "signup";
	    } else if (!regularUser.getPassword().equals(regularUser.getPasswordCheck())) {
	        log.info("Password is not correct");
	        bindingResult.rejectValue("passwordCheck", "err.passCheck", "Passwords does not match");
	        return "signup";
	    } else if (userRepository.findByUsername(regularUser.getUsername()) != null) {
	        log.info("Username already exists");
	        bindingResult.rejectValue("username", "err.username", "Username is already in use");
	        return "signup";
	    } else {
	        String pwd = regularUser.getPassword();
	        BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
	        String hashPwd = bc.encode(pwd);

	        PlayerDatabaseUser newPlayerDatabaseUser = new PlayerDatabaseUser();
	        newPlayerDatabaseUser.setPasswordHash(hashPwd);
	        newPlayerDatabaseUser.setUsername(regularUser.getUsername());
	        newPlayerDatabaseUser.setRole("USER");
	        userRepository.save(newPlayerDatabaseUser);
	    }
	    log.info("User has been succesfully saved!");
	    return "redirect:/login";
	}
	}

