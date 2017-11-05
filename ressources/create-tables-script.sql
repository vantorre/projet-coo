CREATE TABLE players (login VARCHAR(30) primary key);

CREATE TABLE game(
id int primary key,
name VARCHAR(3) NOT NULL,
state VARCHAR(3) NOT NULL,
owner VARCHAR(30) NOT NULL,
winner VARCHAR(30),
roundNumber int,
roundDuration NUMBER(30),
startDateFirstRound DATE,
maxPlayers int,
ressourcesAllowedByRound,

FOREIGN KEY (owner) REFERENCES game(login),
FOREIGN KEY (winner) REFERENCES game(login)
);

CREATE TABLE participe (
login VARCHAR(30),
game int,
lastPlayedRound int,
alive bool,
ressources int,
PRIMARY KEY(login,game),
FOREIGN KEY (login) REFERENCES players(login),
FOREIGN KEY (game) REFERENCES game(id)
);

CREATE TABLE territory(
idGame int,
abscisses int,
ordonnees int,
type VARCHAR(3),
cityOwner VARCHAR(30),
FOREIGN KEY (cityOwner) REFERENCES players(login),
PRIMARY KEY(idGame,abscisses,ordonnees)
);

CREATE TABLE occupe(
player VARCHAR(30),
idGame int,
abscisses int,
ordonnees int,

armyQuantity int,

FOREIGN KEY (player) REFERENCES players(login),
FOREIGN KEY (idGame,abscisses,ordonnees) REFERENCES territory(idGame,abscisses,ordonnees),
PRIMARY KEY(player,idGame,abscisses,ordonnees)
);




