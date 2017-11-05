package facade.response;

import lombok.Builder;
import lombok.Getter;
import mapper.objetMetier.Player;
import mapper.objetMetier.Territory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vantorre on 05/11/17.
 */
@Getter
@Builder
public class TerritoryContentResponseData {
    LoginResponseData cityOwner;
    HashMap<LoginResponseData,Integer> army;

    public TerritoryContentResponseData(Territory territory){
        this.cityOwner=new LoginResponseData(territory.getCityOwner());
        army= new HashMap<LoginResponseData, Integer>();
        Map<Player, Integer> paramArmy = territory.getArmy();
        for(Player player : paramArmy.keySet()){
            army.put(new LoginResponseData(player),paramArmy.get(player));
        }
    }
}
