package mapper.objetMetier;

import com.sun.istack.internal.NotNull;
import lombok.*;

import java.util.List;

/**
 * Created by vantorre on 05/11/17.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Player {
    String login;
    List<Game> games;
}
