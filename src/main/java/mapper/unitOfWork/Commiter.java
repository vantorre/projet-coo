package mapper.unitOfWork;

import mapper.objetMetier.Player;

import java.net.SocketPermission;

/**
 * Created by vantorre on 12/11/17.
 */
public class Commiter extends  Visiteur {
    void visiter(Player player) {
        System.out.println("update player "+player.getLogin());
        //TODO mapper update player
    }
}
