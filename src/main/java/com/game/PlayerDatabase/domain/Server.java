package com.game.PlayerDatabase.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Server {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotEmpty(message = "Server name cannot be empty")
	@Size(min = 3, max = 30)
	private String serverName;
	
	@NotNull(message = "Only numbers are allowed")
	@Min(value = 100, message = "Capacity must be at least 100")
	private int capacity;
	 
	 @OneToMany(mappedBy = "server", cascade = CascadeType.ALL)
	 @JsonIgnore
	 private List<Player> players;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	
	
	
	
	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Server(@NotEmpty(message = "Server name cannot be empty") @Size(min = 3, max = 30) String serverName, @NotNull(message = "Only numbers are allowed") @Min(value = 2, message = "Capacity must be at least 2") int capacity) {
		super();
		this.serverName = serverName;
		this.capacity = capacity;
	}
	
	public Server() {}
	
	@Override
	public String toString() {
		return "Server [id=" + id + ", servername=" + serverName + ", capacity=" + capacity +   ", players="
				+  "]";
	}
	
	
	
	
}
