package facade.response;

import lombok.*;
import mapper.objetMetier.Coordonnees;
import mapper.objetMetier.Game;
import mapper.objetMetier.Territory;

import java.util.HashMap;

/**
 * Created by vantorre on 05/11/17.
 */

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GameResponseData {
    InfosGameResponseData infosPartyResponseData;
    HashMap<CoordonneesResponseData,TerritoryResponseData> territoires;

    public GameResponseData(Game game){
        this.infosPartyResponseData = new InfosGameResponseData(game);
        this.territoires= new HashMap<CoordonneesResponseData, TerritoryResponseData>();
        HashMap<Coordonnees, Territory> territories = game.getTerritory();
        for(Coordonnees coordonnees:territories.keySet()){
            this.territoires.put(new CoordonneesResponseData(coordonnees),new TerritoryResponseData(territories.get(coordonnees)));
        }
    }
}
