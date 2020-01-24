package src.main;

import src.main.Pizza;
import src.main.Order;
import java.rmi.RemoteException;
import java.rmi.ContextException;

public interface PizzaDelivery {

    public boolean setAddress(String address) throws RemoteException;

    public boolean placeOrder(Order o) throws RemoteException;

    public boolean deliver(Context context) throws RemoteException, ContextException;

}