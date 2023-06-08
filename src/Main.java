import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Utilizare Singleton Pattern
        Order order = Order.getInstance();

        // Utilizare Observer Pattern
        User user1 = new User("Max");

        order.attach(user1);

        System.out.println("Bun venit în sistemul de comenzi al restaurantului!");

        while (true) {
            System.out.println("1. Plasați o comandă");
            System.out.println("2. Actualizați starea comenzii");
            System.out.println("3. Vizualizați starea unei comenzi după cod");
            System.out.println("4. Vizualizați toate comenzile unui utilizator");
            System.out.println("0. Ieșire");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.println("Lista de produse disponibile:");
                System.out.println("1. Pizza");
                System.out.println("2. Burger");

                int productChoice = scanner.nextInt();
                scanner.nextLine();

                FoodProductFactory foodProductFactory;
                if (productChoice == 1) {
                    foodProductFactory = new PizzaFactory();
                } else if (productChoice == 2) {
                    foodProductFactory = new BurgerFactory();
                } else {
                    System.out.println("Opțiune invalidă!");
                    continue;
                }

                FoodProduct foodProduct = foodProductFactory.createFoodProduct();

                System.out.println("Doriți extra-uri? (da/nu)");
                String extrasChoice = scanner.nextLine();

                if (extrasChoice.equalsIgnoreCase("da")) {
                    foodProduct = new ExtraCheeseDecorator(foodProduct);
                }

                // Utilizare Strategy Pattern
                PricingStrategy pricingStrategy = choosePricingStrategy(scanner);

                // Calcul preț total
                double totalPrice = calculateTotalPrice(foodProduct, pricingStrategy);

                System.out.println("Comanda plasată cu codul " + order.getOrderCode() + ": " + foodProduct.getDescription());
                System.out.println("Preț total: " + totalPrice + " lei");
                order.setStatus(order.getOrderCode(), "Comanda cu codul " + order.getOrderCode() + " a fost plasată");
            } else if (choice == 2) {
                System.out.println("Introduceți codul comenzii:");
                String orderCode = scanner.nextLine();
                System.out.println("Introduceți noua stare a comenzii:");
                String status = scanner.nextLine();
                order.setStatus(orderCode, status);
            } else if (choice == 3) {
                System.out.println("Introduceți codul comenzii:");
                String orderCode = scanner.nextLine();
                String status = order.getStatus(orderCode);
                if (status != null) {
                    System.out.println("Starea comenzii cu codul " + orderCode + " este: " + status);
                } else {
                    System.out.println("Comanda cu codul " + orderCode + " nu există");
                }
            } else if (choice == 4) {
                System.out.println("Introduceți numele utilizatorului:");
                String username = scanner.nextLine();
                System.out.println("Toate comenzile utilizatorului " + username + ":");
                // TODO: Implementare afișare comenzilor unui utilizator
            } else if (choice == 0) {
                break;
            } else {
                System.out.println("Opțiune invalidă!");
            }
        }

        scanner.close();
    }

    private static PricingStrategy choosePricingStrategy(Scanner scanner) {
        System.out.println("Selectați o strategie de preț:");
        System.out.println("1. Normal");
        System.out.println("2. Premium");

        int strategyChoice = scanner.nextInt();
        scanner.nextLine();

        PricingStrategy pricingStrategy;

        if (strategyChoice == 1) {
            pricingStrategy = new NormalPricingStrategy();
        } else if (strategyChoice == 2) {
            pricingStrategy = new PremiumPricingStrategy();
        } else {
            System.out.println("Opțiune invalidă, se va utiliza strategia Normal");
            pricingStrategy = new NormalPricingStrategy();
        }

        return pricingStrategy;
    }

    private static double calculateTotalPrice(FoodProduct foodProduct, PricingStrategy pricingStrategy) {
        double productPrice = pricingStrategy.calculatePrice(foodProduct);
        double deliveryCost = pricingStrategy.calculateDeliveryCost();
        return productPrice + deliveryCost;
    }
}