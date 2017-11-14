package mapper.objetMetier;

import lombok.*;

import java.util.Calendar;
import java.util.HashMap;

/**
 * Created by vantorre on 05/11/17.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
    int ressourcesInitiales;


    HashMap<Player,PlayerGameStatut> playersGameStatus;
    HashMap<Coordonnees,Territory> territory;
}
