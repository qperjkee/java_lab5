import java.util.List;

/**
 * The {App} class serves as the main entry point for the Coffee Van application.
 * It demonstrates the functionality of the CoffeeVan, adding various types of coffee,
 * sorting them, and finding coffee based on quality ratings.
 */
public class App {
    public static void main(String[] args) {
        // Create a CoffeeVan instance with a maximum volume of 1000 liters
        CoffeeVan van = new CoffeeVan(1000); 

        // List of coffee items to be added to the van
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

        // Attempt to add each coffee item to the van
        for (Coffee coffee : coffeesToAdd) {
            try {
                boolean added = van.addCoffee(coffee); // Add coffee to the van
                if (!added) {
                    // If the van is full, display a warning message
                    System.out.println("Warning: Could not add " + coffee.getName() + " (" + coffee.getState() + ") to the van. The van is full.");
                    break; // Stop adding if the van is full
                }
            } catch (IllegalArgumentException e) {
                // Handle invalid coffee parameters
                System.out.println("Invalid coffee parameters for " + coffee.getName() + " (" + coffee.getState() + "): " + e.getMessage());
            } catch (Exception e) {
                // Handle any other exceptions that may occur
                System.out.println("Error occurred while adding " + coffee.getName() + " (" + coffee.getState() + ") to the van: " + e.getMessage());
            }
        }

        // Display the initial state of the cargo in the van
        System.out.println("\nInitial state of the cargo:");
        van.displayCargo(); 

        // Sort coffee items by price-to-weight ratio and display the updated cargo
        van.sortByPriceWeightRatio();
        System.out.println("\nAfter sorting by price-to-weight ratio:");
        van.displayCargo();

        // Find and display coffee items with a quality rating from 7 to 9
        System.out.println("\nCoffee with quality rating from 7 to 9:");
        List<Coffee> highQualityCoffee = van.findCoffeeByQualityRange(7, 9);

        // Check if any coffee items meet the quality rating criteria
        if (highQualityCoffee.isEmpty()) {
            System.out.println("No coffee found with quality rating in the range 7 to 9.");
        } else {
            // Print details of each coffee item that meets the criteria
            for (Coffee coffee : highQualityCoffee) {
                coffee.printDetails();
            }
        }
    }
}
