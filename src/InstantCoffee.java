/**
 * The {InstantCoffee} class represents coffee in instant form.
 * This class extends the {Coffee} class and includes additional 
 * attributes related to the packaging of the instant coffee.
 */
class InstantCoffee extends Coffee {
    private String packaging;

    /**
     * Constructs an {InstantCoffee} object with the specified attributes,
     * including packaging information.
     * 
     * @param name The name of the instant coffee
     * @param price The price of the instant coffee
     * @param coffeeWeight The weight of the instant coffee
     * @param packagingWeight The weight of the packaging
     * @param coffeeVolume The volume of the instant coffee
     * @param packagingVolume The volume of the packaging
     * @param qualityRating The quality rating of the instant coffee, on a scale from 0 to 10
     * @param packaging The packaging type of the instant coffee
     * @throws NullPointerException if the name is null or empty
     * @throws IllegalArgumentException if price, weights, volumes, rating, or packaging are invalid
     */
    public InstantCoffee(String name, double price, double coffeeWeight, double packagingWeight, 
                         double coffeeVolume, double packagingVolume, int qualityRating, String packaging) {
        super(name, price, coffeeWeight, packagingWeight, coffeeVolume, packagingVolume, qualityRating);
        setPackaging(packaging);
    }

    /**
     * Returns the state of the coffee, which includes the packaging type.
     * 
     * @return a string representing the state of the instant coffee, formatted as 
     *         "Instant (packagingType)"
     */
    @Override
    public String getState() {
        return "Instant (" + packaging + ")";
    }

    /**
     * Returns the packaging type of the instant coffee.
     * 
     * @return the packaging type as a string
     */
    public String getPackaging() { 
        return packaging; 
    }

    /**
     * Sets the packaging type for the instant coffee.
     * 
     * @param packaging The packaging type to be set
     * @throws IllegalArgumentException if the packaging is null or empty
     */
    public void setPackaging(String packaging) { 
        if (packaging == null || packaging.trim().isEmpty()) {
            throw new IllegalArgumentException("Packaging cannot be null or empty.");
        }
        this.packaging = packaging; 
    }

    /**
     * Prints the details of the instant coffee, including all attributes inherited from 
     * the {Coffee} class, as well as the packaging type, followed by a separator line 
     * for visual clarity.
     */
    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Packaging: " + packaging);
        System.out.println("-------------------------------");
    }

    /**
     * Returns a string representation of the instant coffee, including all its attributes
     * from the {Coffee} class and the packaging type.
     * 
     * @return a string representation of the instant coffee
     */
    @Override
    public String toString() {
        return super.toString() + ", packaging='" + packaging + '\'';
    }
}
