package mapper.objetMetier.interfacesObjetMetier;

import mapper.unitOfWork.Observateur;

/**
 * Created by vantorre on 12/11/17.
 */
public interface Observable {
    void add (Observateur observateur);
    void notifier();

}
