package mapper.objetMetier;

import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;
import java.util.HashMap;

/**
 * Created by vantorre on 05/11/17.
 */
@Getter
@Setter
public class Game {
    int idGame;
    String name;
    PartyState state;
    Player owner;
    Player winner;
    int roundNumber;
    Calendar startDateLastRound;
    double roundDuration;
    int maxPlayers;
    int ressourcesAllowedByRound;


    HashMap<Player,PlayerGameStatut> playersGameStatus;
    HashMap<Coordonnees,Territory> territory;
}
