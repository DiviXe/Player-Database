package com.game.PlayerDatabase.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Player {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Getter @Setter private long id;
	@Getter @Setter private String playerName;
	@Getter @Setter private String name;
	@Getter @Setter private Integer birthDateYear;
	@Getter @Setter private String email;
	@Getter @Setter private String password;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "serverid")
	@Getter @Setter private Server server;
	
	public Player() {
		
	}
	
	public Player(String playerName, String name, Integer birthDateYear, String email, String password, Server server) {
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
