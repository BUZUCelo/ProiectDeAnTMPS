import java.util.*;
class BurgerFactory implements FoodProductFactory {
    public FoodProduct createFoodProduct() {
        return new BurgerBuilder()
                .setDescription("Burger")
                .setPrice(8.0)
                .build();
    }
}