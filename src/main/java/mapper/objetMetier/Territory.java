package mapper.objetMetier;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * Created by vantorre on 05/11/17.
 */
@Getter
@Setter
public class Territory {
    TypeTerritory type;
    Player cityOwner;

    Map<Player,Integer> army;
}
