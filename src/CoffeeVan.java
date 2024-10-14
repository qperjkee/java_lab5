import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class CoffeeVan {
    private List<Coffee> cargo;
    private double maxVolume;
    private double currentVolume;
    private double totalValue;

    public CoffeeVan(double maxVolume) {
        if (maxVolume <= 0) {
            throw new IllegalArgumentException("Max volume must be greater than zero.");
        }
        this.maxVolume = maxVolume;
        this.cargo = new ArrayList<>();
        this.currentVolume = 0;
        this.totalValue = 0;
    }

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

    public void sortByPriceWeightRatio() {
        cargo.sort(Comparator.comparingDouble(Coffee::getPriceWeightRatio).reversed());
    }

    public List<Coffee> findCoffeeByQualityRange(int minQuality, int maxQuality) {
        if (minQuality < 0 || maxQuality > 10 || minQuality > maxQuality) {
            throw new IllegalArgumentException("Quality rating must be between 0 and 10, and minQuality cannot be greater than maxQuality.");
        }
        return cargo.stream()
                .filter(c -> c.getQualityRating() >= minQuality && c.getQualityRating() <= maxQuality)
                .collect(Collectors.toList());
    }

    public double getCurrentVolume() { 
        return currentVolume; 
    }

    public double getTotalValue() { 
        return totalValue; 
    }

    public double getMaxVolume() { 
        return maxVolume; 
    }

    public List<Coffee> getCargo() { 
        return new ArrayList<>(cargo); 
    }

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
