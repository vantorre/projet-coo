package mapper.objetMetier;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by vantorre on 05/11/17.
 */
@Getter
@Setter
public class Player {
    String login;
    List<Game> games;
}
