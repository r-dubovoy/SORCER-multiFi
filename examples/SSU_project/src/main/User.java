package src.main

import src.main.Order;

public class User {

    public long id;
    public double balance;
    public ArrayList<Order> orderHistory;

    public User() {
        /* logic for generating id*/
        this.id = %GENERATED_ID%;
    }

    public long getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public ArrayList<Order> getOrderHistory() {
        return orderHistory;
    }

    public void addToBalance(int sum) { this.balance+=sum; }

}