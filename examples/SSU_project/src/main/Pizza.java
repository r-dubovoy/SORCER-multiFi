package src.main;

import java.util.ArrayList;

public class Pizza {

    private String name;
    private int price;
    private ArrayList<String> Ingredients;

    public Pizza(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    private void addIngredient(String ingradient){
        this.Ingredients.add(ingradient);
    }

    private void getIngradientByName(){

    }

    private void removeIngredient(int i){
        this.Ingredients.remove(this.Ingredients.remove(i));
    }

    private void increasePrice(int inc){
        this.price += inc;
    }

    private void decreasePrice(int dec){
        this.price -= dec;
    }

}
