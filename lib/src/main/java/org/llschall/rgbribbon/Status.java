package org.llschall.rgbribbon;

/**
 * Represents the various operational states of the RGB ribbon controller.
 */
public enum Status {
    /**
     * Initial state before starting the rbg-ribbon library
     */
    INIT,
    /**
     * State when the rgb-ribbon has been started,
     * but the Arduino board connection is still processed by the rgb-ribbon library
     */
    STARTED,
    /**
     * State when the Arduino board is successfully connected and operational
     */
    CONNECTED,
}
