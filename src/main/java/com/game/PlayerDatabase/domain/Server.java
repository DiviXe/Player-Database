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
import lombok.Getter;
import lombok.Setter;

@Entity
public class Server {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Getter @Setter private Long id;
	@Getter @Setter private String serverName;
	
	//creating link
	 @ManyToOne
	 @JoinColumn(name = "servercomputerid")
	 @Getter @Setter private ServerComputer servercomputer;
	 
	 @OneToMany(mappedBy = "server", cascade = CascadeType.ALL)
	 @JsonIgnore
	 @Getter @Setter private List<Player> players;
	
	public Server() {
		super();
	}
	
	public Server(String serverName) {
		super();
		this.serverName = serverName;
	}
	
	@Override
	public String toString() {
		return "Server [id=" + id + ", servername=" + serverName + ", servercomputer=" + servercomputer + ", players="
				+  "]";
	}
	
	
}
