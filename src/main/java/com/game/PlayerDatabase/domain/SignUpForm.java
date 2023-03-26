package com.game.PlayerDatabase.domain;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class SignUpForm {
	@NotEmpty(message = "Username cannot be empty!")
    @Size(min=5, max=30)
    private String username = "";

    @NotEmpty (message = "Password cannot be empty!")
    @Size(min=7, max=30)
    private String password = "";

    @NotEmpty (message = "Password has to be a match")
    @Size(min=7, max=30)
    private String passwordCheck = "";

    @NotEmpty (message = "User cannot be empty.")
    private String role = "USER";

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordCheck() {
		return passwordCheck;
	}

	public void setPasswordCheck(String passwordCheck) {
		this.passwordCheck = passwordCheck;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
    
    
}

