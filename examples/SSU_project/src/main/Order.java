package src.main;

import src.main.Pizza;

public class Order {

    private String adress;
    private long UserID;
    private long OrderID;
    private ArrayList<Pizza> pizzas;
    private double price;

    public Order() {

    }

    public void setAddress(String adress) { this.address = adress; }

    public String getAdress() { return this.adress; }

    public void addPizza(Pizza p) {
        this.pizzas.add(p);
        this.price += p.price;
    }

    public void cancelPizza(int index) {
        this.pizzas.remove(index);
        this.price -= p.price;
    }

    public double getPrice() { return this.price; }

    public ArrayList<Pizza> getPizzas() { return pizzas; }

    public void getOrderID() { return this.OrderID; }

    private void setPrice(double price) { this.price = price; }

    private void setUserID(long userID) { this.UserID = userID; }

    private void getUserID() { return this.UserID; }

    private void generateOrderID(long userID, *args) { /*logic for generating order ID on the basis of some info, particularly, id of the client*/ this.OrderID = %GENERATED_ID% }

}