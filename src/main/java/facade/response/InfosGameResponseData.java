package facade.response;

import lombok.Getter;
import lombok.Setter;
import mapper.objetMetier.Game;
import mapper.objetMetier.PartyState;

import java.util.Calendar;

/**
 * Created by vantorre on 05/11/17.
 */
@Getter
@Setter
public class InfosGameResponseData {
    int idPartie;
    String name;
    LoginResponseData owner;
    PartyState stateParty;
    int roundNumber;
    double roundDuration;
    Calendar lastRoundDate;
    int maxPlayers;
    int ressourcesAllowedByRound;

    public InfosGameResponseData(Game game){
        this.idPartie=game.getIdGame();
        this.name=game.getName();
        this.owner= new LoginResponseData(game.getOwner());
        this.stateParty=game.getState();
        this.roundNumber =game.getRoundNumber();
        this.roundDuration = game.getRoundDuration();
        this.lastRoundDate =game.getStartDateLastRound();
        this.maxPlayers=game.getMaxPlayers();
        this.ressourcesAllowedByRound=game.getRessourcesAllowedByRound();
    }
}
