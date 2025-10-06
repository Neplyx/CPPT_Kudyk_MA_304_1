package KI304.Kudyk.Lab3;

import static java.lang.System.out;
import java.io.*;

/**
 * Demonstration class for TouchScreen functionality.
 * @author Kudyk
 * @version 1.0
 */
public class TouchScreenApp {
    public static void main(String[] args) {
        try {
            TouchScreen ts = new TouchScreen();

            ts.turnOn();
            ts.connect("USB-C");
            ts.setResolution("2560x1440");

            ts.touch(120, 300);
            ts.touch(400, 600);
            ts.displayInfo();

            ts.clearTouches();
            ts.displayInfo();

            ts.turnOff();
            ts.dispose();

            out.println("Program executed successfully. Check log file for details.");
        } catch (FileNotFoundException e) {
            out.println("Error: " + e.getMessage());
        }
    }
}
