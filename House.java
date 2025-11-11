import java.util.ArrayList;

public class House extends Building implements HouseRequirements{
  private ArrayList<Student> residents; 
  private boolean hasDiningRoom;
  private boolean hasElevator; 

  /* Default Constructor */
  public House() { 
    this("<Name Unknown>", "<Address Unknown>", 1, false, false); 
  }

  /**
   * Overloaded constructor with address only
   * @param address the address of the house
   */
  public House(String address) { 
    this(); 
    this.address = address; 
  }

  /**
   * Overloaded constructor with name and address
   * @param name the name of the house
   * @param address the address of the house
   */
  public House(String name, String address) { 
    this(); 
    this.name = name; 
    this.address = address; 
  }
  /** 
   * Constructor for House Class 
   * @param name the name of the house 
   * @param address the house's address 
   * @param nFloors the number of floors in the house 
   * @param hasElevator whether or not the house has an elevator
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) { 
    super(name, address, nFloors); 
    this.residents = new ArrayList<Student>(); 
    this.hasDiningRoom = hasDiningRoom; 
    this.hasElevator = hasElevator; 
    System.out.println("You have built a house: 🏠");
  }

  /**
   * Accessor for hasDiningRoom value
   * @return true if house has dining room, false otherwise
   */
  public boolean hasDiningRoom() {
    return this.hasDiningRoom; 
  }

  /**
   * Accessor for nResidents value
   * @return number of residents in house
   */
  public int nResidents() { 
    return this.residents.size(); 
  }

  /**
   * Adds student to house upon move in
   * @param s the Student who wants to move in 
   */
  public void moveIn(Student s) { 
    this.residents.add(s); 
  }

  /**
   * Removes student from house upon move out 
   * @param s the Student who wants to move out 
   * @return s the Student who moved out 
   */
  public Student moveOut(Student s) { 
    this.residents.remove(s); 
    return s; 
  }

  /**
   * Whether or not a given person is a resident of the house 
   * @param s student who we want to confirm is a resident of the house 
   * @return true if s is resident of house, false otherwise 
   */
  public boolean isResident(Student s) { 
    if (this.residents.contains(s)) { 
      return true; 
    } else { 
      return false; 
    }
  }

  /**
   * Converts values to string for testing. 
   * @return String containing all useful information about House. 
   */
  public String toString() { 
    return (super.toString() + "and they have " + this.nResidents() + " residents. They also have a dining hall (true/false): " + this.hasDiningRoom()); 
  }

  /**
   * Overrides the showOptions method from building class to use the options from this class
   */
  @Override
  public void showOptions() { 
    super.showOptions();
    System.out.println(" + hasDiningRoom() \n + nResidents() \n + moveIn(n) \n + moveOut(n)\n + isResident(n)");
  }

  /**
   * Overrides the goToFloor method from Building class to account for elevators
   */
  @Override
  public void goToFloor(int floorNum) {
        if (!((floorNum == this.activeFloor + 1) || (floorNum == this.activeFloor - 1)) && !this.hasElevator) {
            throw new RuntimeException("This building does not have an elevator. Cannot move to non-adjacent floors without an elevator.");
        }
        super.goToFloor(floorNum);
    }

  public static void main(String[] args) {
    House House = new House("Northrop", "1 Elm Street", 5, true, true); 
    House.showOptions(); 
    House.enter();
    House.goToFloor(4);
    System.out.println(House.toString());
    Student ab = new Student("Ab", "9909abc", 2014);
    House.moveIn(ab);
    System.out.println(House.toString());
  }
}