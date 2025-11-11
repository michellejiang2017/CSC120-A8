public class Cafe extends Building implements CafeRequirements {

    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    /* Default constructor */
    public Cafe() {
        this("<Name Unknown>", "<Address Unknown>", 1, 0, 0, 0, 0);
    }

    /* Overloaded constructor with address only */
    public Cafe(String address)  { 
        this(); 
        this.address = address; 
    }

    /* Overloaded constructor with name and address */
    public Cafe(String name, String address) {
        this(name, address, 1, 0, 0, 0, 0); 
    }

    /**
     * Full constructor for cafe class
     * @param name the name of the cafe
     * @param address the address of the cafe
     * @param nFloors the number of floors in the building
     * @param nCoffeeOunces the number of ounces of coffee initially 
     * @param nSugarPackets the number of sugar packets initially 
     * @param nCreams the number of creams intially 
     * @param nCups the number of cups initially 
     */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        int maxCoffeeOunces = nCoffeeOunces; 
        this.nCoffeeOunces = maxCoffeeOunces; 
        int maxSugarPackets = nSugarPackets; 
        this.nSugarPackets = maxSugarPackets; 
        int maxCreams = nCreams; 
        this.nCreams = maxCreams; 
        int maxCups = nCups; 
        this.nCups = maxCups; 
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * Method to sell coffee in the cafe. 
     * @param size the amount of coffee sold 
     * @param nSugarPackets the number of sugar packets used 
     * @param nCreams the number of creams used 
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        if (this.nCoffeeOunces > size && this.nSugarPackets > nSugarPackets && this.nCreams > nCreams && this.nCups > 1) {
        this.nCoffeeOunces -= size; 
        this.nSugarPackets -= nSugarPackets; 
        this.nCreams -= nCreams; 
        this.nCups -= 1; 
        System.out.println("Coffee sold!");
        } else {
            restock(size, nSugarPackets, nCreams, nCreams);
            this.nCoffeeOunces -= size; 
            this.nSugarPackets -= nSugarPackets; 
            this.nCreams -= nCreams; 
            this.nCups -= 1; 
            System.out.println("Coffee sold!");
        }
    }

    /**
     * Restocks the cafe when they run out of materials 
     * @param nCoffeeOunces the amount of coffee to be added 
     * @param nSugarPackets the number of sugars to be added
     * @param nCreams the number of creams to be added
     * @param nCups the number of cups to be added
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces += nCoffeeOunces; 
        this.nSugarPackets += nSugarPackets; 
        this.nCreams += nCreams; 
        this.nCups += nCups; 
        System.out.println("Restocked!");
    }
    
    /**
     * Overrides the showOptions method from building class to use the options from this class
     */
    @Override
    public void showOptions() { 
        System.out.println("Available options at " + this.name + ":\n + sellCoffee(n) \n + restock()");
    }

    /**
     * Overrides the goToFloor method from Building class to account for cafe
     */
    @Override
    public void goToFloor(int floorNum) {
        if (floorNum != activeFloor) {
          throw new RuntimeException("This building only has one floor."); 
        }
    }

    public static void main(String[] args) {
        Cafe compassCafe = new Cafe("Compass Cafe", "1 Chapin Way", 1, 10, 10, 10, 2);
        compassCafe.showOptions();
        for (int i=0; i<10; i++) {
        compassCafe.sellCoffee(5, 2, 2);
        }
    }
}
