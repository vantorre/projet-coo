package mapper.objetMetier;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * Created by vantorre on 05/11/17.
 */
@Getter
@Setter
@AllArgsConstructor
public class Territory {
    TypeTerritory type;
    Player cityOwner;
    Map<Player,Integer> army;
    public Territory(TypeTerritory type){
        this.type=type;
    }
}
