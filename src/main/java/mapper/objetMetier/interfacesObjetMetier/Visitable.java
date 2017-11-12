package mapper.objetMetier.interfacesObjetMetier;

import mapper.unitOfWork.Visiteur;

/**
 * Created by vantorre on 12/11/17.
 */
public interface Visitable {
    void accepter(Visiteur visiteur);
}
