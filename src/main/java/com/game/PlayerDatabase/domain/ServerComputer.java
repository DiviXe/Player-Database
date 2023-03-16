package com.game.PlayerDatabase.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
public class ServerComputer {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    @NotEmpty(message = "PC's name cannot be empty")
    private String computerName;
    @NotEmpty(message = "Status should contain at least a word ")
    @Size(min = 2, max = 60)
    private String computerStatus;
    
    @NotEmpty(message = "The ip shouldn't be empty")
    @Size(min = 10, max = 60)
    private String  computerIP;
    
    @ManyToOne
    @JoinColumn(name = "server_id")
    private Server server;
    
    public ServerComputer() {}
    
    public ServerComputer(@NotEmpty(message = "PC's name cannot be empty")String computerName, @NotEmpty(message = "Status should contain at least a word ") @Size(min = 2, max = 60)String computerStatus, @NotEmpty(message = "The ip shouldn't be empty")
    @Size(min = 10, max = 60) String computerIP, Server server) {
        super();
        this.computerName = computerName;
        this.computerStatus = computerStatus;
        this.computerIP = computerIP;
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
    
    public String getComputerIP() {
        return computerIP;
    }
    
    public void setComputerIP(String computerIP) {
        this.computerIP = computerIP;
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
                + ", computerIP=" + computerIP + "]";
    }
}
