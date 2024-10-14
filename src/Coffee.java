/**
 * The {Coffee} class represents a general model for different types of coffee,
 * encapsulating details such as name, price, weight, volume, and quality rating. 
 * It also provides methods to calculate the price/weight ratio, total weight, 
 * and total volume of the coffee along with its packaging.
 * 
 * This class is abstract, meaning specific types of coffee (e.g., GroundCoffee, InstantCoffee) 
 * must extend this class and provide implementation for the abstract method {getState()}.
 */
abstract class Coffee {

    /** Name of the coffee. */
    protected String name;

    /** Price of the coffee. */
    protected double price;

    /** Weight of the coffee itself (in kilograms). */
    protected double coffeeWeight;

    /** Weight of the packaging (in kilograms). */
    protected double packagingWeight;

    /** Volume of the coffee itself (in liters). */
    protected double coffeeVolume;

    /** Volume of the packaging (in liters). */
    protected double packagingVolume;

    /** Quality rating of the coffee, on a scale from 0 to 10. */
    protected int qualityRating;

    /**
     * Constructs a {Coffee} object with the specified attributes.
     * 
     * @param name The name of the coffee
     * @param price The price of the coffee
     * @param coffeeWeight The weight of the coffee
     * @param packagingWeight The weight of the packaging
     * @param coffeeVolume The volume of the coffee
     * @param packagingVolume The volume of the packaging
     * @param qualityRating The quality rating of the coffee, on a scale from 0 to 10
     * @throws NullPointerException if the name is null or empty
     * @throws IllegalArgumentException if price, weights, volumes, or rating are invalid
     */
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

    /**
     * Returns the state of the coffee (e.g., ground, bean, etc.).
     * This method must be implemented by subclasses.
     * 
     * @return the state of the coffee
     */
    public abstract String getState();

    /**
     * Calculates and returns the price/weight ratio for the coffee.
     * 
     * @return the price per kilogram of coffee
     * @throws ArithmeticException if the total weight is zero
     */
    public double getPriceWeightRatio() {
        double totalWeight = getTotalWeight();
        if (totalWeight == 0) {
            throw new ArithmeticException("Total weight cannot be zero when calculating price/weight ratio.");
        }
        return price / totalWeight;
    }

    /**
     * Returns the total weight of the coffee including its packaging.
     * 
     * @return the total weight of the coffee and packaging
     */
    public double getTotalWeight() {
        return coffeeWeight + packagingWeight;
    }

    /**
     * Returns the total volume of the coffee including its packaging.
     * 
     * @return the total volume of the coffee and packaging
     */
    public double getTotalVolume() {
        return coffeeVolume + packagingVolume;
    }

    /** 
     * Returns the name of the coffee.
     * 
     * @return the name of the coffee
     */
    public String getName() { 
        return name; 
    }

    /**
     * Returns the price of the coffee.
     * 
     * @return the price of the coffee
     */
    public double getPrice() { 
        return price; 
    }

    /** 
     * Returns the weight of the coffee.
     * 
     * @return the weight of the coffee
     */
    public double getCoffeeWeight() { 
        return coffeeWeight; 
    }

    /**
     * Returns the weight of the packaging.
     * 
     * @return the weight of the packaging
     */
    public double getPackagingWeight() { 
        return packagingWeight; 
    }

    /** 
     * Returns the volume of the coffee.
     * 
     * @return the volume of the coffee
     */
    public double getCoffeeVolume() { 
        return coffeeVolume; 
    }

    /**
     * Returns the volume of the packaging.
     * 
     * @return the volume of the packaging
     */
    public double getPackagingVolume() { 
        return packagingVolume; 
    }

    /** 
     * Returns the quality rating of the coffee.
     * 
     * @return the quality rating of the coffee
     */
    public int getQualityRating() { 
        return qualityRating; 
    }

    /**
     * Sets the name of the coffee.
     * 
     * @param name the name of the coffee
     * @throws NullPointerException if the name is null or empty
     */
    public void setName(String name) { 
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException("Name cannot be null or empty.");
        }
        this.name = name; 
    }

    /**
     * Sets the price of the coffee.
     * 
     * @param price the price of the coffee
     * @throws IllegalArgumentException if the price is less than or equal to zero
     */
    public void setPrice(double price) { 
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be greater than zero.");
        }
        this.price = price; 
    }

    /**
     * Sets the weight of the coffee.
     * 
     * @param coffeeWeight the weight of the coffee
     * @throws IllegalArgumentException if the coffee weight is negative
     */
    public void setCoffeeWeight(double coffeeWeight) { 
        if (coffeeWeight < 0) {
            throw new IllegalArgumentException("Coffee weight cannot be negative.");
        }
        this.coffeeWeight = coffeeWeight; 
    }

    /**
     * Sets the weight of the packaging.
     * 
     * @param packagingWeight the weight of the packaging
     * @throws IllegalArgumentException if the packaging weight is negative
     */
    public void setPackagingWeight(double packagingWeight) { 
        if (packagingWeight < 0) {
            throw new IllegalArgumentException("Packaging weight cannot be negative.");
        }
        this.packagingWeight = packagingWeight; 
    }

    /**
     * Sets the volume of the coffee.
     * 
     * @param coffeeVolume the volume of the coffee
     * @throws IllegalArgumentException if the coffee volume is negative
     */
    public void setCoffeeVolume(double coffeeVolume) { 
        if (coffeeVolume < 0) {
            throw new IllegalArgumentException("Coffee volume cannot be negative.");
        }
        this.coffeeVolume = coffeeVolume; 
    }

    /**
     * Sets the volume of the packaging.
     * 
     * @param packagingVolume the volume of the packaging
     * @throws IllegalArgumentException if the packaging volume is negative
     */
    public void setPackagingVolume(double packagingVolume) { 
        if (packagingVolume < 0) {
            throw new IllegalArgumentException("Packaging volume cannot be negative.");
        }
        this.packagingVolume = packagingVolume; 
    }

    /**
     * Sets the quality rating of the coffee.
     * 
     * @param qualityRating the quality rating of the coffee
     * @throws IllegalArgumentException if the quality rating is outside the range of 0 to 10
     */
    public void setQualityRating(int qualityRating) { 
        if (qualityRating < 0 || qualityRating > 10) {
            throw new IllegalArgumentException("Quality rating must be between 0 and 10.");
        }
        this.qualityRating = qualityRating; 
    }

    /**
     * Prints the details of the coffee, including name, type, price, total weight,
     * total volume, quality rating, and price/weight ratio.
     */
    public void printDetails() {
        System.out.println("Name: " + name);
        System.out.println("Type: " + getState());
        System.out.println("Price: $" + String.format("%.2f", price));
        System.out.println("Total Weight: " + String.format("%.2f", getTotalWeight()) + " kg");
        System.out.println("Total Volume: " + String.format("%.2f", getTotalVolume()) + " L");
        System.out.println("Quality Rating: " + qualityRating);
        System.out.println("Price/Weight Ratio: $" + String.format("%.2f", getPriceWeightRatio()) + " per kg");
    }

    /**
     * Returns a string representation of the coffee, including its attributes
     * such as name, price, weight, volume, and quality rating.
     * 
     * @return a string representation of the coffee
     */
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
