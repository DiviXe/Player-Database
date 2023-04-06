package com.game.PlayerDatabase.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Player {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotEmpty(message = "Player name cannot be empty")
	@Size(min = 3, max = 60)
	@Column(name ="player_name")
	private String playerName;
	
	@NotEmpty(message = "Your real name should contain first name and last name")
	@Size(min = 3, max = 60)
	private String name;
	
	//not null for integers!
	@NotNull(message = "Only give birthdate year.")
	@Column(name ="birth_date_year")
	private Integer birthDateYear;
	
	@NotEmpty(message = "Email should be an valid email")
	private String email;
	
	//Pattern REGEX Validation 
	@NotEmpty(message = "Password shouldn't be empty!")
	@Size(min = 7, max = 60)
	@Pattern(regexp = "^(?=.*[A-Z])(?=.*[0-9]).*$", message = "Password must contain at least one uppercase letter and one digit")
	private String password;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "server_id")
	private Server server;
	
	public Player() {}
	
	public Player(@NotEmpty(message = "Player's name cannot be empty") @Size(min = 3, max = 60)String playerName, @NotEmpty(message = "Your real name should contain first name and last name")
	@Size(min = 3, max = 60) String name, @NotNull(message = "Only give birthdate year.") Integer birthDateYear, @NotEmpty(message = "Email should be an valid email") String email, 	@NotEmpty(message = "Password shouldn't be empty!")
	@Size(min = 3, max = 60) @Pattern(regexp = "^(?=.*[A-Z])(?=.*[0-9]).*$", message = "Password must contain at least one uppercase letter and one digit")
	String password, Server server) {
		super();
		this.playerName = playerName;
		this.name = name;
		this.birthDateYear = birthDateYear;
		this.email = email;
		this.password = password;
		this.server = server;
	}
	
	


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getBirthDateYear() {
		return birthDateYear;
	}

	public void setBirthDateYear(Integer birthDateYear) {
		this.birthDateYear = birthDateYear;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Server getServer() {
		return server;
	}

	public void setServer(Server server) {
		this.server = server;
	}

	@Override
	public String toString() {
		return "Player [playerName=" + playerName + ", name=" + name + ", birthDateYear=" + birthDateYear
				+ ", email=" + email + ", password=" + password + "]";
	}
	
}
