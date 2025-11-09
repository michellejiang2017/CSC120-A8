import java.util.ArrayList;

public class House extends Building implements HouseRequirements{
  private ArrayList<Student> residents; 
  private boolean hasDiningRoom;

  /** 
   * Constructor for House Class 
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom) { 
    super(name, address, nFloors); 
    this.residents = new ArrayList<Student>(); 
    this.hasDiningRoom = hasDiningRoom; 
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
   * Is this overriding the showOptions() method from building? 
   */
  public void showOptions() { 
    System.out.println("Available options at " + this.name + ":\n + hasDiningRoom() \n + nResidents() \n + moveIn(n) \n + moveOut(n)\n + isResident(n)");
  }

  public static void main(String[] args) {
    House House = new House("Northrop", "1 Elm Street", 5, true); 
    House.showOptions(); 
    System.out.println(House.toString());
    Student ab = new Student("Ab", "9909abc", 2014);
    House.moveIn(ab);
    System.out.println(House.toString());
  }
}