import java.util.*;
class NormalPricingStrategy implements PricingStrategy {
    public double calculatePrice(FoodProduct foodProduct) {
        return foodProduct.getPrice();
    }

    public double calculateDeliveryCost() {
        return 2.0;
    }
}