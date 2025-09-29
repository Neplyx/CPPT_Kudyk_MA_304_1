package KI304.Kudyk.Lab2;

import static java.lang.System.out;
import java.io.*;

/**
 * Demonstration class for Monitor
 */
public class MonitorApp {
    public static void main(String[] args) throws FileNotFoundException {
        Monitor monitor = new Monitor();

        monitor.turnOn();
        monitor.increaseBrightness();
        monitor.setResolution("2560x1440");
        monitor.connect("DisplayPort");

        out.println("Current resolution: " + monitor.getResolution());

        monitor.decreaseBrightness();
        monitor.turnOff();
        monitor.dispose();
    }
}
