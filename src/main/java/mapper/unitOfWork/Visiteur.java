package mapper.unitOfWork;

import mapper.objetMetier.Player;
import mapper.objetMetier.interfacesObjetMetier.IObjetMetier;

/**
 * Created by vantorre on 12/11/17.
 */
public abstract class Visiteur {
    void visiter(IObjetMetier iObjetMetier){
        iObjetMetier.accepter(this);
    }
    abstract void visiter(Player player);
}
