package KI304.Kudyk.Lab6;

/**
 * Interface <code>Item</code> defines common behavior
 * for all objects that can be stored in a container.
 *
 * @author Kudyk
 * @version 1.0
 */
public interface Item extends Comparable<Item> {
    /**
     * Returns the size parameter of the object.
     * @return integer value representing the size
     */
    int getSize();

    /** Prints information about the object */
    void print();
}
