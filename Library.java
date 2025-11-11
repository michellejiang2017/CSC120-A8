import java.util.Hashtable;

public class Library extends Building implements LibraryRequirements{

  private Hashtable<String, Boolean> collection; 
  private boolean hasElevator; 

  /* Default constructor */
  public Library() { 
    this("<Name Unknown>", "<Address Unknown>", 1, false); 
  }

  /**
   * Overloaded constructor with address only 
   * @param address the address of the library 
   */
  public Library(String address) { 
    this(); 
    this.address = address; 
  }

  /**
   * Overloaded constructor with name and address
   * @param name the name of the library
   * @param address the address of the library
   */
  public Library(String name, String address) { 
    this(); 
    this.name = name; 
    this.address = address; 
  }
  /**
   * Constructor for Library class
   * @param name Library's name
   * @param address Library's address
   * @param nFloors Number of floors in library
   * @param hasElevator whether or not the library has an elevator
   */
    public Library(String name, String address, int nFloors, boolean hasElevator) {
      super(name, address, nFloors); 
      this.collection = new Hashtable<String, Boolean>(); 
      this.hasElevator = hasElevator; 
      System.out.println("You have built a library: 📖");
    }
  
    /**
     * adds title to library collection 
     * @param title the title to be added 
     */
    public void addTitle(String title) { 
      this.collection.put(title, true); 
    }

    /**
     * removes title from collection 
     * @param title the title to be removed
     * @return return the title that was removed
     */
    public String removeTitle(String title) { 
      this.collection.remove(title); 
      return title; 
    }
    
    /**
     * checks out a book by changing the value of the respective title to false 
     * @param title of book to be checked out 
     */
    public void checkOut(String title) { 
      this.collection.replace(title, false); 
    }

    /**
     * returns the book by changing the value of the respective title to true 
     * @param title the book to be returned
     */
    public void returnBook(String title) { 
      this.collection.replace(title, true); 
    }
    
    /**
     * returns true if the title appears as a key in the Libary's collection, false otherwise
     * @param title the book that is being tested 
     * @return whether or not the library has the title in its collection
     */
    public boolean containsTitle(String title) { 
     if (this.collection.containsKey(title)) { 
      return true; 
     } else {
      return false; 
     }
    }
    
    /**
     * returns true if the title is currently available, false otherwise
     * @param title the book that is being tested
     * @return whether or not the book is available 
     */
    public boolean isAvailable(String title) { 
      if (this.collection.get(title)) {
        return true; 
      } else {
        return false; 
      }
    }

    /**
     * prints out the entire collection in an easy-to-read way (including checkout status)
     */
    public void printCollection() { 
      System.out.println(this.name + "'s Collection");
      System.out.println("---------------------------");
      System.out.println("Title Name | Availability");
      System.out.println("--------------------------");
      for (String key: collection.keySet()) { 
        System.out.println(key + " | " + collection.get(key));
      }
    }

    /**
     * Overrides the showOptions method from building class to use the options from this class
     */
    @Override
    public void showOptions() { 
      System.out.println("Available options at " + this.name + ":\n + addTitle(n) \n + removeTitle(n) \n + checkOut(n) \n + returnBook(n)\n + containsTitle(n)\n + isAvailable(n)");
    }

    /**
     * Overrides the goToFloor method from Building class to account for elevators
     */
    @Override
    public void goToFloor(int floorNum) {
          if ((floorNum+1 != this.activeFloor || floorNum-1 != this.activeFloor) && !this.hasElevator) {
            throw new RuntimeException("This building does not have an elevator."); 
          }
          super.goToFloor(floorNum);
      }


    public static void main(String[] args) {
      Library library = new Library("Neilson Library", "123 Chapin Street", 4, true);
      String[] titles = {"The Hunger Games", "Divergent", "The Giver", "Geronimo Stilton", "Braiding Sweetgrass", "Coding for Dummies", "The Night Ends with Fire"}; 
      for (int i=0; i< titles.length; i++) { 
        library.addTitle(titles[i]);
        System.out.println(titles[i] + " added.");
      }
      library.showOptions();
      library.enter(); 
      library.goToFloor(4);
      library.checkOut(titles[3]);
      library.printCollection();
    }
  
  }