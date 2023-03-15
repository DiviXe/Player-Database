package com.game.PlayerDatabase.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Player {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotEmpty(message = "Title Player name cannot be empty")
	private String playerName;
	private String name;
	private Integer birthDateYear;
	private String email;
	private String password;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "serverid")
	private Server server;
	
	public Player() {}
	
	public Player(@NotEmpty(message = "Player's name cannot be empty") @Size(min = 6, max = 60)String playerName, String name, Integer birthDateYear, String email, String password, Server server) {
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
