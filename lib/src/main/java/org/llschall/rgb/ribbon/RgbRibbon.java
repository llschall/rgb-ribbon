package org.llschall.rgb.ribbon;

import java.util.function.Consumer;

/**
 * Controls an RGB LED ribbon/strip, providing functionality to manage individual LEDs
 * and overall ribbon settings.
 */
public class RgbRibbon {

    /**
     * Current version of the RGB Ribbon library
     */
    public static String VERSION = RgbRibbonImpl.VERSION;

    /**
     * Implementation object that handles the low-level ribbon control
     */
    final RgbRibbonImpl impl;

    /**
     * Creates a new RGB ribbon controller with specified brightness
     *
     * @param brightness Initial brightness level for the ribbon (0-255)
     */
    public RgbRibbon(int brightness) {
        impl = new RgbRibbonImpl();
    }

    /**
     * Initializes and starts the ribbon operation
     */
    public void start() {
        impl.start();
    }

    /**
     * Toggles the built-in LED state (on/off)
     */
    public void toggleBuiltInLed() {
        impl.toggleBuiltInLed();
    }

    /**
     * Publishes the current LED states to the physical ribbon
     */
    public void publish() {
        impl.publish();
    }

    /**
     * Adds a listener to monitor status changes of the ribbon
     *
     * @param consumer Consumer that handles status updates
     */
    public void addStatusListener(Consumer<Status> consumer) {
        impl.addStatusListener(consumer);
    }

    /**
     * Gets a specific LED from the ribbon for individual control
     *
     * @param i Index of the LED to control
     * @return RgbLed object representing the LED at the specified index
     */
    public RgbLed getLed(int i) {
        return impl.getLed(i);
    }

    /**
     * Updates the overall brightness of the ribbon
     *
     * @param brightness New brightness value (0-255)
     */
    public void setBrightness(int brightness) {
        impl.updateBrightness(brightness);
    }
}
