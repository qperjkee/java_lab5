import java.util.List;

public class App {
    public static void main(String[] args) {
        CoffeeVan van = new CoffeeVan(1000);

        List<Coffee> coffeesToAdd = List.of(
            new CoffeeBean("Arabica", 100, 0.9, 0.1, 1.5, 0.5, 9),
            new CoffeeBean("Robusta", 90, 0.85, 0.15, 1.4, 0.6, 8),
            new GroundCoffee("Colombian", 80, 0.45, 0.05, 0.4, 0.1, 8),
            new GroundCoffee("Ethiopian", 85, 0.48, 0.07, 0.45, 0.15, 9),
            new InstantCoffee("Nescafe", 120, 0.15, 0.05, 0.15, 0.35, 7, "Jar"),
            new InstantCoffee("Jacobs", 50, 0.09, 0.01, 0.08, 0.02, 6, "Sachet"),
            new InstantCoffee("Starbucks", 130, 0.18, 0.07, 0.2, 0.4, 8, "Jar"),
            new CoffeeBean("Kenyan", 110, 0.95, 0.12, 1.6, 0.55, 9),
            new GroundCoffee("Brazilian", 75, 0.42, 0.06, 0.38, 0.12, 7),
            new InstantCoffee("Lavazza", 140, 0.2, 0.08, 0.22, 0.38, 8, "Tin")
        );

        for (Coffee coffee : coffeesToAdd) {
            try {
                boolean added = van.addCoffee(coffee);
                if (!added) {
                    System.out.println("Warning: Could not add " + coffee.getName() + " to the van. The van is full.");
                    break;
                }
            } catch (Exception e) {
                System.out.println("Error occurred while adding " + coffee.getName() + " to the van: " + e.getMessage());
            }
        }

        System.out.println("\nInitial state of the cargo:");
        van.displayCargo(); 

        van.sortByPriceWeightRatio();
        System.out.println("\nAfter sorting by price-to-weight ratio:");
        van.displayCargo();

        System.out.println("\nCoffee with quality rating from 7 to 9:");
        List<Coffee> highQualityCoffee = van.findCoffeeByQualityRange(7, 9);

        if (highQualityCoffee.isEmpty()) {
            System.out.println("No coffee found with quality rating in the range 7 to 9.");
        } else {
            for (Coffee coffee : highQualityCoffee) {
                coffee.printDetails();
            }
        }
    }
}
