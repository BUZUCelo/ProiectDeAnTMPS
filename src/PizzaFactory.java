import java.util.*;
class PizzaFactory implements FoodProductFactory {
    public FoodProduct createFoodProduct() {
        return new PizzaBuilder()
                .setDescription("Pizza")
                .setPrice(10.0)
                .build();
    }
}