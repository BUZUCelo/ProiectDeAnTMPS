import java.util.*;
interface PricingStrategy {
    double calculatePrice(FoodProduct foodProduct);

    double calculateDeliveryCost();
}