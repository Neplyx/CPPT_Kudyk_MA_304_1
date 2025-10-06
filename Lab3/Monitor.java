package KI304.Kudyk.Lab3;

import java.io.*;

/**
 * Abstract class Monitor models a generic computer monitor.
 * Serves as a base for more specialized displays such as TouchScreen.
 * @author Kudyk
 * @version 2.0
 */
public abstract class Monitor {
    protected Screen screen;
    protected PowerButton powerButton;
    protected Port port;
    protected boolean isOn;
    protected PrintWriter log;

    /** Constructor */
    public Monitor() throws FileNotFoundException {
        screen = new Screen();
        powerButton = new PowerButton();
        port = new Port("HDMI");
        isOn = false;
        log = new PrintWriter(new File("monitor_log.txt"));
    }

    /** Turns monitor on */
    public void turnOn() {
        isOn = true;
        log.println("Monitor turned ON");
        log.flush();
    }

    /** Turns monitor off */
    public void turnOff() {
        isOn = false;
        log.println("Monitor turned OFF");
        log.flush();
    }

    /** Sets monitor resolution */
    public void setResolution(String resolution) {
        screen.setResolution(resolution);
        log.println("Resolution set to " + resolution);
        log.flush();
    }

    /** Returns current resolution */
    public String getResolution() {
        return screen.getResolution();
    }

    /** Connects monitor to a port */
    public void connect(String portName) {
        port = new Port(portName);
        log.println("Monitor connected via " + portName);
        log.flush();
    }

    /** Disconnects monitor */
    public void disconnect() {
        port = null;
        log.println("Monitor disconnected");
        log.flush();
    }

    /** Closes log file */
    public void dispose() {
        log.close();
    }

    /** Abstract method that must be implemented by subclasses */
    public abstract void displayInfo();
}

/** Screen class */
class Screen {
    private int brightness;
    private String resolution;

    public Screen() {
        brightness = 50;
        resolution = "1920x1080";
    }

    public void setBrightness(int brightness) { this.brightness = brightness; }
    public int getBrightness() { return brightness; }

    public void setResolution(String resolution) { this.resolution = resolution; }
    public String getResolution() { return resolution; }
}

/** Power Button */
class PowerButton {
    private boolean state;
    public PowerButton() { state = false; }
}

/** Port class */
class Port {
    private String type;
    public Port(String type) { this.type = type; }
}
