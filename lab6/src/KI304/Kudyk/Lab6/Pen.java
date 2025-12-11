package KI304.Kudyk.Lab6;

/**
 * Class <code>Pen</code> represents a pen object
 * with brand name and physical length.
 *
 * @author Kudyk
 * @version 1.0
 */
public class Pen implements Item {
    /** Brand name */
    private String brand;
    /** Pen length in millimeters */
    private int length;

    /**
     * Constructor for initializing a pen
     * @param brand brand name
     * @param length pen length in mm
     */
    public Pen(String brand, int length) {
        this.brand = brand;
        this.length = length;
    }

    /** {@inheritDoc} */
    @Override
    public int getSize() {
        return length;
    }

    /** {@inheritDoc} */
    @Override
    public int compareTo(Item other) {
        return Integer.compare(this.getSize(), other.getSize());
    }

    /** {@inheritDoc} */
    @Override
    public void print() {
        System.out.println("Pen: " + brand + ", length: " + length + " mm");
    }
}
