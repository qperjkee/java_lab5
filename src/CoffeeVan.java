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
        this.maxVolume = maxVolume;
        this.cargo = new ArrayList<>();
        this.currentVolume = 0;
        this.totalValue = 0;
    }

    public boolean addCoffee(Coffee coffee) {
        if (currentVolume + coffee.getTotalVolume() <= maxVolume) {
            cargo.add(coffee);
            currentVolume += coffee.getTotalVolume();
            totalValue += coffee.getPrice();
            return true;
        }
        return false;
    }

    public void sortByPriceWeightRatio() {
        cargo.sort(Comparator.comparingDouble(Coffee::getPriceWeightRatio).reversed());
    }

    public List<Coffee> findCoffeeByQualityRange(int minQuality, int maxQuality) {
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
        System.out.println("====================================");
    }
}
