import java.util.*;
class Burger implements FoodProduct {


    private String description;
    private double price;

    public Burger(String description, double price) {
        this.description = description;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}