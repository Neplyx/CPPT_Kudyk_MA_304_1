package KI304.Kudyk.Lab3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class TouchScreen extends Monitor and implements Touchable interface.
 * Models a touchscreen device with basic touch interaction.
 * @author Kudyk
 * @version 1.0
 */
public class TouchScreen extends Monitor implements Touchable {
    private List<String> touchPoints;

    /** Constructor */
    public TouchScreen() throws FileNotFoundException {
        super();
        touchPoints = new ArrayList<>();
        log.println("TouchScreen created");
        log.flush();
    }

    /** Implements touch event */
    @Override
    public void touch(int x, int y) {
        String point = "(" + x + "," + y + ")";
        touchPoints.add(point);
        log.println("Touched at: " + point);
        log.flush();
    }

    /** Clears all touches */
    @Override
    public void clearTouches() {
        touchPoints.clear();
        log.println("Screen cleared of touches");
        log.flush();
    }

    /** Displays information about screen state */
    @Override
    public void displayInfo() {
        log.println("TouchScreen Info: Resolution = " + getResolution() + 
                    ", Touch points = " + touchPoints.size());
        log.flush();
    }
}
