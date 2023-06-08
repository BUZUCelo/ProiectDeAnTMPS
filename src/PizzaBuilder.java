import java.util.*;
class PizzaBuilder {
    private String description;
    private double price;

    public PizzaBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public PizzaBuilder setPrice(double price) {
        this.price = price;
        return this;
    }

    public Pizza build() {
        return new Pizza(description, price);
    }
}