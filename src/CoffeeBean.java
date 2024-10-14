/**
 * The {CoffeeBean} class represents coffee in the form of beans.
 * This class extends the {Coffee} class and provides implementation
 * for the abstract method {Coffee.getState()} to specify that the state
 * of this coffee is "Bean".
 */
class CoffeeBean extends Coffee {

    /**
     * Constructs a {CoffeeBean} object with the specified attributes.
     * 
     * @param name The name of the coffee
     * @param price The price of the coffee
     * @param coffeeWeight The weight of the coffee beans
     * @param packagingWeight The weight of the packaging
     * @param coffeeVolume The volume of the coffee beans
     * @param packagingVolume The volume of the packaging
     * @param qualityRating The quality rating of the coffee beans, on a scale from 0 to 10
     * @throws NullPointerException if the name is null or empty
     * @throws IllegalArgumentException if price, weights, volumes, or rating are invalid
     */
    public CoffeeBean(String name, double price, double coffeeWeight, double packagingWeight, 
                      double coffeeVolume, double packagingVolume, int qualityRating) {
        super(name, price, coffeeWeight, packagingWeight, coffeeVolume, packagingVolume, qualityRating);
    }

    /**
     * Prints the details of the coffee bean, including all attributes inherited from
     * the {Coffee} class, followed by a separator line for visual clarity.
     */
    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("-------------------------------");
    }

    /**
     * Returns the state of the coffee, which is "Bean" for this class.
     * 
     * @return the string "Bean", representing the state of the coffee
     */
    @Override
    public String getState() {
        return "Bean";
    }
}
