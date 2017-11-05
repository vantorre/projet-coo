package mapper.objetMetier;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by vantorre on 05/11/17.
 */
@Getter
@Setter
public class PlayerGameStatut {
    Boolean alive;
    int ressources;
    int lastRoundPlayed;
}
