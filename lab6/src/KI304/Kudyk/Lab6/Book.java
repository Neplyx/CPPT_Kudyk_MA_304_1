package KI304.Kudyk.Lab6;

/**
 * Class <code>Book</code> represents a book object
 * with title and number of pages.
 *
 * @author Kudyk
 * @version 1.0
 */
public class Book implements Item {
    /** Title of the book */
    private String title;
    /** Number of pages */
    private int pages;

    /**
     * Constructor for initializing a book
     * @param title book title
     * @param pages number of pages
     */
    public Book(String title, int pages) {
        this.title = title;
        this.pages = pages;
    }

    /** {@inheritDoc} */
    @Override
    public int getSize() {
        return pages;
    }

    /** {@inheritDoc} */
    @Override
    public int compareTo(Item other) {
        return Integer.compare(this.getSize(), other.getSize());
    }

    /** {@inheritDoc} */
    @Override
    public void print() {
        System.out.println("Book: " + title + ", pages: " + pages);
    }
}
