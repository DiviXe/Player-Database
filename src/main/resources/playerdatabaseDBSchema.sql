SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS server;
DROP TABLE IF EXISTS player;
DROP TABLE IF EXISTS server_computer;
DROP TABLE IF EXISTS player_database_user;

SET FOREIGN_KEY_CHECKS=1;

CREATE TABLE server (
  id BIGINT NOT NULL AUTO_INCREMENT,
  server_name VARCHAR(30) NOT NULL,
  capacity INT NOT NULL CHECK (capacity >= 100),
  PRIMARY KEY (id)
  
);

INSERT INTO server (server_name, capacity) VALUES ("Randuins", 2000),
("Albama", 1500), ("The Crocket", 1300), ("Mindgard", 1700), ("Ragnaros", 2000);


CREATE TABLE server_computer (
  id BIGINT NOT NULL AUTO_INCREMENT,
  computer_name VARCHAR(255) NOT NULL,
  computer_status VARCHAR(255) NOT NULL,
  computer_ip VARCHAR(255) NOT NULL,
  server_id BIGINT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (server_id) REFERENCES server (id)
);

INSERT INTO server_computer (computer_name, computer_status, computer_ip, server_id)
VALUES ("Windows_1", "OK", "198.5.56.43", 1),
("Windows_2", "OK", "208.64.53.102", 5),
("Windows_3", "OK", "198.64.21.54", 4),
("Windows_4", "OK", "198.43.78.65", 3),
("Windows_5", "OK", "152.42.67.64", 2),
("Windows_6", "OK_BACKUP_PC", "151.64.63.123", 5),
("Windows_7", "OK_BACKUP_PC", "198.20.52.50", 4);


CREATE TABLE player (
    id BIGINT NOT NULL AUTO_INCREMENT,
    player_name VARCHAR(60) NOT NULL,
    name VARCHAR(60) NOT NULL,
    birth_date_year INTEGER NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(60) NOT NULL,
    server_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (server_id) REFERENCES server(id)
);

INSERT INTO player (player_name, name, birth_date_year, email, password, server_id) VALUES
("Aramed", "Leo Heikkinen", 1997, "leoheik@gmail.com", "tervevaan55", 1),
("Decker", "Jouni Ekon", 2000, "jouniekon@gmail.com", "CamelCase66", 2),
("Armedguy", "Teemu selan", 1987, "gameing565@gmail.com", "ThEePiC761", 3),
("Iconic53", "Pete Parkens", 1992, "petepark@gmail.com", "petepark1992", 3),
("TheGates", "Eckberg Sandel", 1990, "eckkergeggers@gmail.com", "Erkkionparas123", 4),
("Hetus", "Manu Teeru", 2002, "sillymyy6@gmail.com", "ThemindBlow44", 5),
("Sufule", "Sulkka Pulkka", 1990, "textanddrive@gmail.com", "SickBoi353", 5),
("ArcEnemy", "Erk Herb", 1999, "erbge@gmail.com", "Thesetters99", 5);


CREATE TABLE player_database_user (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255) NULL,
    last_name VARCHAR(255) NULL,
    role VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL
);

INSERT INTO player_database_user (first_name, last_name, role, username, password_hash)
VALUES ("Leo", "Ahopalo", "ADMIN", "Leo",
			"$2a$10$2Gm74iOxuJZsVVKIF47aiut3PBzMVI8REsQ.JngNDu/rrJoS8dum."),
		("Leo", "testi", "USER", "user", 
			"$2a$10$2Gm74iOxuJZsVVKIF47aiut3PBzMVI8REsQ.JngNDu/rrJoS8dum.");
			
SELECT * from server;
SELECT * from server_computer;
SELECT * from player;
SELECT * from player_database_user;
