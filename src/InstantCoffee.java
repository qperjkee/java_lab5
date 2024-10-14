class InstantCoffee extends Coffee {
    private String packaging;

    public InstantCoffee(String name, double price, double coffeeWeight, double packagingWeight, 
                         double coffeeVolume, double packagingVolume, int qualityRating, String packaging) {
        super(name, price, coffeeWeight, packagingWeight, coffeeVolume, packagingVolume, qualityRating);
        this.packaging = packaging;
    }

    @Override
    public String getState() {
        return "Instant (" + packaging + ")";
    }

    public String getPackaging() { 
        return packaging; 
    }

    public void setPackaging(String packaging) { 
        this.packaging = packaging; 
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Packaging: " + packaging);
    }

    @Override
    public String toString() {
        return super.toString() + ", packaging='" + packaging + '\'';
    }
}
