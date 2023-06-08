import java.util.*;
class BurgerBuilder {
    private String description;
    private double price;

    public BurgerBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public BurgerBuilder setPrice(double price) {
        this.price = price;
        return this;
    }

    public Burger build() {
        return new Burger(description, price);
    }
}