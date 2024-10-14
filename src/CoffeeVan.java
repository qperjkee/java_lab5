import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The {CoffeeVan} class represents a van that can carry various types of coffee.
 * It maintains a cargo of coffee items, tracks the current volume and total value of the cargo, 
 * and provides functionality to add coffee, sort by price-to-weight ratio, and find coffee by quality range.
 */
class CoffeeVan {
    private List<Coffee> cargo;
    private double maxVolume;
    private double currentVolume;
    private double totalValue;

    /**
     * Constructs a {CoffeeVan} with a specified maximum volume.
     * 
     * @param maxVolume The maximum volume the coffee van can carry
     * @throws IllegalArgumentException if maxVolume is less than or equal to zero
     */
    public CoffeeVan(double maxVolume) {
        if (maxVolume <= 0) {
            throw new IllegalArgumentException("Max volume must be greater than zero.");
        }
        this.maxVolume = maxVolume;
        this.cargo = new ArrayList<>();
        this.currentVolume = 0;
        this.totalValue = 0;
    }

    /**
     * Adds a coffee item to the van's cargo if there is enough volume available.
     * 
     * @param coffee The coffee item to be added
     * @return {true} if the coffee was successfully added; {false} otherwise
     * @throws IllegalArgumentException if the coffee volume is less than or equal to zero
     */
    public boolean addCoffee(Coffee coffee) {
        double coffeeVolume = coffee.getTotalVolume();
        if (coffeeVolume <= 0) {
            throw new IllegalArgumentException("Coffee volume must be greater than zero.");
        }
        if (currentVolume + coffeeVolume <= maxVolume) {
            cargo.add(coffee);
            currentVolume += coffeeVolume;
            totalValue += coffee.getPrice();
            return true;
        }
        return false;
    }

    /**
     * Sorts the cargo by the price-to-weight ratio in descending order.
     */
    public void sortByPriceWeightRatio() {
        cargo.sort(Comparator.comparingDouble(Coffee::getPriceWeightRatio).reversed());
    }

    /**
     * Finds and returns a list of coffee items within a specified quality rating range.
     * 
     * @param minQuality The minimum quality rating
     * @param maxQuality The maximum quality rating
     * @return a list of coffee items that meet the quality rating criteria
     * @throws IllegalArgumentException if the quality ratings are out of range or minQuality is greater than maxQuality
     */
    public List<Coffee> findCoffeeByQualityRange(int minQuality, int maxQuality) {
        if (minQuality < 0 || maxQuality > 10 || minQuality > maxQuality) {
            throw new IllegalArgumentException("Quality rating must be between 0 and 10, and minQuality cannot be greater than maxQuality.");
        }
        return cargo.stream()
                .filter(c -> c.getQualityRating() >= minQuality && c.getQualityRating() <= maxQuality)
                .collect(Collectors.toList());
    }

    /**
     * Returns the current volume of cargo in the van.
     * 
     * @return the current volume
     */
    public double getCurrentVolume() { 
        return currentVolume; 
    }

    /**
     * Returns the total value of the cargo in the van.
     * 
     * @return the total value
     */
    public double getTotalValue() { 
        return totalValue; 
    }

    /**
     * Returns the maximum volume capacity of the van.
     * 
     * @return the maximum volume
     */
    public double getMaxVolume() { 
        return maxVolume; 
    }

    /**
     * Returns a list of all coffee items currently in the cargo.
     * 
     * @return a list of coffee items
     */
    public List<Coffee> getCargo() { 
        return new ArrayList<>(cargo); 
    }

    /**
     * Displays the current cargo details of the coffee van, including the total items, current volume, total value, 
     * and details of each coffee item in the cargo.
     */
    public void displayCargo() {
        System.out.println("====================================");
        System.out.println("Coffee Van Cargo Details:");
        System.out.println("====================================");
        System.out.println("Total Items: " + cargo.size());
        System.out.println("Current Volume: " + String.format("%.2f", currentVolume) + " / " + maxVolume + " L");
        System.out.println("Total Value: $" + String.format("%.2f", totalValue));
        System.out.println("====================================");
        System.out.println("Individual Coffee Details:");
        for (Coffee coffee : cargo) {
            coffee.printDetails();
        }
    }
}
