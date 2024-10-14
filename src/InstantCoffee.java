class InstantCoffee extends Coffee {
    private String packaging;

    public InstantCoffee(String name, double price, double coffeeWeight, double packagingWeight, 
                         double coffeeVolume, double packagingVolume, int qualityRating, String packaging) {
        super(name, price, coffeeWeight, packagingWeight, coffeeVolume, packagingVolume, qualityRating);
        setPackaging(packaging);
    }

    @Override
    public String getState() {
        return "Instant (" + packaging + ")";
    }

    public String getPackaging() { 
        return packaging; 
    }

    public void setPackaging(String packaging) { 
        if (packaging == null || packaging.trim().isEmpty()) {
            throw new IllegalArgumentException("Packaging cannot be null or empty.");
        }
        this.packaging = packaging; 
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Packaging: " + packaging);
        System.out.println("-------------------------------");
    }

    @Override
    public String toString() {
        return super.toString() + ", packaging='" + packaging + '\'';
    }
}
