import java.util.*;
class PremiumPricingStrategy implements PricingStrategy {
    public double calculatePrice(FoodProduct foodProduct) {
        return foodProduct.getPrice() + 2.0;
    }

    public double calculateDeliveryCost() {
        return 0.0;
    }
}