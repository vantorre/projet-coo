package mapper.unitOfWork;

import mapper.objetMetier.interfacesObjetMetier.IObjetMetier;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vantorre on 12/11/17.
 */
public class UnitOfWork implements Observateur{
    private static final UnitOfWork INSTANCE = new UnitOfWork();
    private UnitOfWork(){
        objetsMetiersModifiers=new ArrayList<IObjetMetier>();
    }
    public UnitOfWork getInstance(){
        return INSTANCE;
    }

    private List<IObjetMetier> objetsMetiersModifiers;

    public void action(IObjetMetier iObjetMetier) {
        if(!objetsMetiersModifiers.contains(iObjetMetier)){
            objetsMetiersModifiers.add(iObjetMetier);
        }
    }
    public void commit(){
        Visiteur visiteur = new Commiter();
        for(IObjetMetier objetMetier : objetsMetiersModifiers){
            visiteur.visiter(objetMetier);
        }
        objetsMetiersModifiers.clear();
    }
}
