package mapper.unitOfWork;

import mapper.objetMetier.interfacesObjetMetier.IObjetMetier;

/**
 * Created by vantorre on 12/11/17.
 */
public interface Observateur {
    void action(IObjetMetier iObjetMetier);
}
