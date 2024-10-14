class CoffeeBean extends Coffee {
    public CoffeeBean(String name, double price, double coffeeWeight, double packagingWeight, 
                      double coffeeVolume, double packagingVolume, int qualityRating) {
        super(name, price, coffeeWeight, packagingWeight, coffeeVolume, packagingVolume, qualityRating);
    }

    @Override
    public String getState() {
        return "Bean";
    }
}
