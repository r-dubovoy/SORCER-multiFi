package src.main;

import src.main.Pizza;
import java.rmi.RemoteException;

public interface PizzaOrdering {

    public boolean addPizza(Pizza p)  throws RemoteException;

    public boolean setPrice(Pizza p, int pr) throws RemoteException;

    public boolean addIngredient(Pizza p, String ingredient) throws RemoteException;

    public boolean removeIngredient(Pizza p, String ingredient) throws RemoteException;

    public boolean increasePrice(Pizza p, int inc) throws RemoteException;

    public boolean decreasePrice(Pizza p, int dec) throws RemoteException;

}
