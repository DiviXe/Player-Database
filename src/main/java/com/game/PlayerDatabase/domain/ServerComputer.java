package com.game.PlayerDatabase.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
public class ServerComputer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Getter @Setter private Long id;
	
	@Getter @Setter private String computerName;
	@Getter @Setter private String computerStatus;
	@Getter @Setter private String serverCapacity;
	
	@OneToMany(mappedBy = "servercomputer", cascade = CascadeType.ALL)
	@JsonIgnore
	@Getter @Setter private List<Server> servers;
	
	
	public ServerComputer() {
		super();
	}

	
	public ServerComputer(String computerName, String computerStatus, String serverCapacity) {
		super();
		this.computerName = computerName;
		this.computerStatus = computerStatus;
		this.serverCapacity = serverCapacity;
		//this.servers = servers;
	}

	@Override
	public String toString() {
		return "ServerComputer [id=" + id + ", computerName=" + computerName + ", computerStatus=" + computerStatus
				+ ", serverCapacity=" + serverCapacity + "]";
	}

	
	
}
