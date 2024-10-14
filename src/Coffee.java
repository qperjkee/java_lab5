abstract class Coffee {
    protected String name;
    protected double price;
    protected double coffeeWeight;
    protected double packagingWeight;
    protected double coffeeVolume;
    protected double packagingVolume;
    protected int qualityRating;

    public Coffee(String name, double price, double coffeeWeight, double packagingWeight, 
                  double coffeeVolume, double packagingVolume, int qualityRating) {
        setName(name);
        setPrice(price);
        setCoffeeWeight(coffeeWeight);
        setPackagingWeight(packagingWeight);
        setCoffeeVolume(coffeeVolume);
        setPackagingVolume(packagingVolume);
        setQualityRating(qualityRating);
    }

    public abstract String getState();

    public double getPriceWeightRatio() {
        double totalWeight = getTotalWeight();
        if (totalWeight == 0) {
            throw new ArithmeticException("Total weight cannot be zero when calculating price/weight ratio.");
        }
        return price / totalWeight;
    }

    public double getTotalWeight() {
        return coffeeWeight + packagingWeight;
    }

    public double getTotalVolume() {
        return coffeeVolume + packagingVolume;
    }

    public String getName() { 
        return name; 
    }

    public double getPrice() { 
        return price; 
    }

    public double getCoffeeWeight() { 
        return coffeeWeight; 
    }

    public double getPackagingWeight() { 
        return packagingWeight; 
    }

    public double getCoffeeVolume() { 
        return coffeeVolume; 
    }

    public double getPackagingVolume() { 
        return packagingVolume; 
    }

    public int getQualityRating() { 
        return qualityRating; 
    }

    public void setName(String name) { 
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException("Name cannot be null or empty.");
        }
        this.name = name; 
    }

    public void setPrice(double price) { 
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be greater than zero.");
        }
        this.price = price; 
    }

    public void setCoffeeWeight(double coffeeWeight) { 
        if (coffeeWeight < 0) {
            throw new IllegalArgumentException("Coffee weight cannot be negative.");
        }
        this.coffeeWeight = coffeeWeight; 
    }

    public void setPackagingWeight(double packagingWeight) { 
        if (packagingWeight < 0) {
            throw new IllegalArgumentException("Packaging weight cannot be negative.");
        }
        this.packagingWeight = packagingWeight; 
    }

    public void setCoffeeVolume(double coffeeVolume) { 
        if (coffeeVolume < 0) {
            throw new IllegalArgumentException("Coffee volume cannot be negative.");
        }
        this.coffeeVolume = coffeeVolume; 
    }

    public void setPackagingVolume(double packagingVolume) { 
        if (packagingVolume < 0) {
            throw new IllegalArgumentException("Packaging volume cannot be negative.");
        }
        this.packagingVolume = packagingVolume; 
    }

    public void setQualityRating(int qualityRating) { 
        if (qualityRating < 0 || qualityRating > 10) {
            throw new IllegalArgumentException("Quality rating must be between 0 and 10.");
        }
        this.qualityRating = qualityRating; 
    }


    public void printDetails() {
        System.out.println("Name: " + name);
        System.out.println("Type: " + getState());
        System.out.println("Price: $" + String.format("%.2f", price));
        System.out.println("Total Weight: " + String.format("%.2f", getTotalWeight()) + " kg");
        System.out.println("Total Volume: " + String.format("%.2f", getTotalVolume()) + " L");
        System.out.println("Quality Rating: " + qualityRating);
        System.out.println("Price/Weight Ratio: $" + String.format("%.2f", getPriceWeightRatio()) + " per kg");
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", coffeeWeight=" + coffeeWeight +
                ", packagingWeight=" + packagingWeight +
                ", totalWeight=" + getTotalWeight() +
                ", coffeeVolume=" + coffeeVolume +
                ", packagingVolume=" + packagingVolume +
                ", totalVolume=" + getTotalVolume() +
                ", qualityRating=" + qualityRating +
                ", state='" + getState() + '\'' +
                ", priceWeightRatio=" + String.format("%.2f", getPriceWeightRatio()) +
                '}';
    }
}