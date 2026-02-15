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
     * Creates a new RGB ribbon controller with a brightness of 80
     */
    public RgbRibbon() {
        this(80, 100_000);
    }

    /**
     * Creates a new RGB ribbon controller with specified brightness
     *
     * @param brightness Initial brightness level (0-255)
     */
    public RgbRibbon(int brightness, int postMs) {
        impl = new RgbRibbonImpl(brightness, postMs);
    }

    /**
     * Initializes and starts the ribbon operation
     */
    public void start() {
        impl.start(true, false);
    }

    /**
     * Initializes and starts the ribbon operation with an option to retry connection
     *
     * @param retry    Whether to retry connection on failure
     * @param trayIcon Whether to show a tray icon for status indication
     */
    public void start(boolean retry, boolean trayIcon) {
        impl.start(retry, trayIcon);
    }

    /**
     * Starts the current LED effect
     */
    public void startEffect() {
        impl.startEffect();
    }

    /**
     * public void stopEffect() {
     * impl.stopEffect();
     * }
     * <p>
     * /**
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
