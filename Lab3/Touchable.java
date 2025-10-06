package KI304.Kudyk.Lab3;

/**
 * Interface Touchable defines touch-related behavior.
 * @author Kudyk
 * @version 1.0
 */
public interface Touchable {
    /**
     * Simulates a touch event on the screen.
     * @param x X-coordinate of touch.
     * @param y Y-coordinate of touch.
     */
    void touch(int x, int y);

    /**
     * Clears the screen from touch points.
     */
    void clearTouches();
}
