package KI304.Kudyk.Lab6;

/**
 * Class <code>Lab6KudykKI304</code> demonstrates the work
 * of a parameterized class <code>Container</code> that stores
 * and processes objects of different types implementing the
 * <code>Item</code> interface.
 *
 * @author Kudyk
 * @version 1.0
 */
public class Lab6KudykKI304 {

    /**
     * Entry point of the program. Demonstrates the use
     * of parameterized programming in Java.
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        
        // Create a container for items implementing Item interface
        Container<Item> box = new Container<>();

        // Add different types of items
        box.addItem(new Book("Java Programming", 250));
        box.addItem(new Pen("Pilot G2", 20));
        box.addItem(new Book("Algorithms", 350));
        box.addItem(new Pen("Parker", 30));

        // Find the largest item
        Item maxItem = box.findMax();
        System.out.println("\nThe largest item in the container:");
        maxItem.print();

        // Remove the second element
        box.removeItem(1);
        System.out.println("\nAfter removing the second element:");
        box.printAll();
    }
}
