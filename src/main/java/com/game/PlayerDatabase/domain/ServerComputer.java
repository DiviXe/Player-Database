package com.game.PlayerDatabase.domain;


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
public class ServerComputer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	 private Long id;
	
	private String computerName;
	 private String computerStatus;
	 private String serverCapacity;
	
	@OneToMany(mappedBy = "servercomputer", cascade = CascadeType.ALL)
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "server_id")
	 private Server server;
	
	
	public ServerComputer() {
		super();
	}

	
	public ServerComputer(String computerName, String computerStatus, String serverCapacity, Server server) {
	    super();
	    this.computerName = computerName;
	    this.computerStatus = computerStatus;
	    this.serverCapacity = serverCapacity;
	    this.server = server;
	}
	
	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getComputerName() {
		return computerName;
	}


	public void setComputerName(String computerName) {
		this.computerName = computerName;
	}


	public String getComputerStatus() {
		return computerStatus;
	}


	public void setComputerStatus(String computerStatus) {
		this.computerStatus = computerStatus;
	}


	public String getServerCapacity() {
		return serverCapacity;
	}


	public void setServerCapacity(String serverCapacity) {
		this.serverCapacity = serverCapacity;
	}


	public Server getServer() {
		return server;
	}


	public void setServer(Server server) {
		this.server = server;
	}


	@Override
	public String toString() {
		return "ServerComputer [id=" + id + ", computerName=" + computerName + ", computerStatus=" + computerStatus
				+ ", serverCapacity=" + serverCapacity + "]";
	}

	
	
}
