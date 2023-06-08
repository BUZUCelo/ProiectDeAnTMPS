// Implementarea produselor alimentare
import java.util.*;
class Pizza implements FoodProduct {
    private String description;
    private double price;

    public Pizza(String description, double price) {
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