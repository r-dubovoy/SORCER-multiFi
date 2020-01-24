package src.main;

import src.main.Pizza;
import src.main.Order;
import java.rmi.RemoteException;
import java.rmi.ContextException;

public interface PizzaCheckout {

    public boolean receiveOrder(Order o) throws RemoteException;

    public boolean withdrawFromAccount(int sum) throws RemoteException;

    public boolean addToOrderHistory(Order o) throws RemoteException;

}