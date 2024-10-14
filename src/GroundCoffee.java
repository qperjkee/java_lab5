/**
 * The {GroundCoffee} class represents coffee in the form of ground coffee.
 * This class extends the {Coffee} class and provides implementation
 * for the abstract method {Coffee.getState()} to specify that the state
 * of this coffee is "Ground".
 */
class GroundCoffee extends Coffee {

    /**
     * Constructs a {GroundCoffee} object with the specified attributes.
     * 
     * @param name The name of the ground coffee
     * @param price The price of the ground coffee
     * @param coffeeWeight The weight of the ground coffee
     * @param packagingWeight The weight of the packaging
     * @param coffeeVolume The volume of the ground coffee
     * @param packagingVolume The volume of the packaging
     * @param qualityRating The quality rating of the ground coffee, on a scale from 0 to 10
     * @throws NullPointerException if the name is null or empty
     * @throws IllegalArgumentException if price, weights, volumes, or rating are invalid
     */
    public GroundCoffee(String name, double price, double coffeeWeight, double packagingWeight, 
                        double coffeeVolume, double packagingVolume, int qualityRating) {
        super(name, price, coffeeWeight, packagingWeight, coffeeVolume, packagingVolume, qualityRating);
    }

    /**
     * Prints the details of the ground coffee, including all attributes inherited from
     * the {Coffee} class, followed by a separator line for visual clarity.
     */
    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("-------------------------------");
    }

    /**
     * Returns the state of the coffee, which is "Ground" for this class.
     * 
     * @return the string "Ground", representing the state of the coffee
     */
    @Override
    public String getState() {
        return "Ground";
    }
}
