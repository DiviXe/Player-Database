package com.game.PlayerDatabase.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Server {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String serverName;
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

	public Server(String serverName, int capacity) {
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
