package facade.response;

import lombok.Getter;
import lombok.Setter;
import mapper.objetMetier.Player;

/**
 * Created by vantorre on 04/11/17.
 */
@Getter
@Setter
public class LoginResponseData {
    String login;

    public LoginResponseData(Player player){
        this.login=player.getLogin();
    }
}
