package service;

import lombok.Setter;
import mapper.mapper.GameMapper;
import mapper.objetMetier.*;

import java.sql.SQLException;
import java.util.HashMap;

/**
 * Created by vantorre on 14/11/17.
 */
@Setter
public class GameServiceImpl implements GameService {
    GameMapper gameMapper;
    ActualPlayer actualPlayer= ActualPlayer.getInstance();
    public void createGame(String nom, int dureeTour, int nbMaxPlayers, int tailleCarte, int distMinVille, int qtResTour, int qtInitRes) throws SQLException {
        HashMap<Coordonnees, Territory> territory = generateRandomMap(tailleCarte);
        //TODO les villes seront créées au moment ou chaque joueur rejoin la partie car on ne peut enregistrer une ville vide
        Game game=Game.builder()
                .name(nom)
                .roundDuration(dureeTour)
                .maxPlayers(nbMaxPlayers)
                .ressourcesAllowedByRound(qtResTour)
                .ressourcesInitiales(qtInitRes)
                .owner(Player.builder().login(actualPlayer.getLogin()).build())
                .roundNumber(0)
                .state(PartyState.Waiting)
                .territory(territory)
                .build();
        gameMapper.creerGame(game );
    }

    private HashMap<Coordonnees, Territory> generateRandomMap(int tailleCarte) {
        HashMap<Coordonnees, Territory> map= new HashMap<Coordonnees, Territory>();
        for(int x=0;x<tailleCarte;x++){
            for(int y=0;y<tailleCarte;y++){
                map.put(new Coordonnees(x,y),getRandomTypeTerritory());
            }
        }
        map.get(getRandomCoordonee(tailleCarte)).setCityOwner(Player.builder().login(actualPlayer.getLogin()).build());
        return map;
    }

    private Coordonnees getRandomCoordonee(int tailleCarte) {
        return new Coordonnees((int)(Math.random() * (tailleCarte-1)),(int)(Math.random() * (tailleCarte-1)));
    }

    private Territory getRandomTypeTerritory() {
        int random = (int)(Math.random() * 3);
        switch(random){
            case 0 : return new Territory(TypeTerritory.Mountain);
            case 1 : return new Territory(TypeTerritory.Plain);
            default : return new Territory(TypeTerritory.Field);
        }
    }
}
