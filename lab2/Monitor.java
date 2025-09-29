package KI304.Kudyk.Lab2;

import java.io.*;

/**
 * Class Monitor models a computer monitor with basic functionality.
 * @author Kudyk
 * @version 1.0
 */
public class Monitor {
    private Screen screen;
    private PowerButton powerButton;
    private Port port;
    private boolean isOn;
    private PrintWriter log;

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

    /** Increases screen brightness */
    public void increaseBrightness() {
        screen.setBrightness(screen.getBrightness() + 10);
        log.println("Brightness increased to " + screen.getBrightness());
        log.flush();
    }

    /** Decreases screen brightness */
    public void decreaseBrightness() {
        screen.setBrightness(screen.getBrightness() - 10);
        log.println("Brightness decreased to " + screen.getBrightness());
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
