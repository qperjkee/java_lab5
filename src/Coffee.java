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
        this.name = name;
        this.price = price;
        this.coffeeWeight = coffeeWeight;
        this.packagingWeight = packagingWeight;
        this.coffeeVolume = coffeeVolume;
        this.packagingVolume = packagingVolume;
        this.qualityRating = qualityRating;
    }

    public abstract String getState();

    public double getPriceWeightRatio() {
        return price / getTotalWeight();
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
        this.name = name; 
    }

    public void setPrice(double price) { 
        this.price = price; 
    }

    public void setCoffeeWeight(double coffeeWeight) { 
        this.coffeeWeight = coffeeWeight; 
    }

    public void setPackagingWeight(double packagingWeight) { 
        this.packagingWeight = packagingWeight; 
    }

    public void setCoffeeVolume(double coffeeVolume) { 
        this.coffeeVolume = coffeeVolume; 
    }

    public void setPackagingVolume(double packagingVolume) { 
        this.packagingVolume = packagingVolume; 
    }

    public void setQualityRating(int qualityRating) { 
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