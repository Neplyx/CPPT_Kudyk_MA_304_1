    package KI304.Kudyk.Lab6;

    import java.util.ArrayList;

    /**
     * Class <code>Container</code> represents a generic
     * container for storing and processing items of type T.
     *
     * @param <T> type parameter extending Item interface
     * @author Kudyk
     * @version 1.0
     */
    public class Container<T extends Item> {
        /** List to store items */
        private ArrayList<T> items;

        /** Default constructor */
        public Container() {
            items = new ArrayList<>();
        }

        /**
         * Adds an item to the container
         * @param item element to be added
         */
        public void addItem(T item) {
            items.add(item);
            System.out.print("Added item: ");
            item.print();
        }

        /**
         * Removes an item from the container by index
         * @param index index of element to remove
         */
        public void removeItem(int index) {
            if (index >= 0 && index < items.size()) {
                System.out.println("Removed item:");
                items.get(index).print();
                items.remove(index);
            }
        }

        /**
         * Finds the maximum element in the container
         * according to compareTo method
         * @return maximal item or null if empty
         */
        public T findMax() {
    if (items.isEmpty())
        return null;
    T max = null;
    for (T item : items) {
        if (item.getSize() < 50) {
            if (max == null || item.compareTo(max) > 0) {
                max = item;
            }
        }
    }
    return max;
}


        /** Prints all elements in the container */
        public void printAll() {
            System.out.println("Container contents:");
            for (T item : items)
                item.print();
        }
    }
