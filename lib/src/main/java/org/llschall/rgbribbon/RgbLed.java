package org.llschall.rgbribbon;

import java.awt.Color;

/**
 * Represents an RGB LED with individual control over red, green, and blue components.
 * Each color component can be set independently or all at once using a Color object.
 */
public class RgbLed {

    /**
     * Red component value (0-255)
     */
    int red;
    /**
     * Green component value (0-255)
     */
    int green;
    /**
     * Blue component value (0-255)
     */
    int blue;

    /**
     * Constructs an RgbLed instance
     */
    public RgbLed() {
        // create instance only
    }

    /**
     * Sets the red component of the LED
     *
     * @param value The red intensity (0-255)
     */
    public void setRed(int value) {
        red = value;
    }

    /**
     * Sets the green component of the LED
     *
     * @param value The green intensity (0-255)
     */
    public void setGreen(int value) {
        green = value;
    }

    /**
     * Sets the blue component of the LED
     *
     * @param value The blue intensity (0-255)
     */
    public void setBlue(int value) {
        blue = value;
    }

    /**
     * Sets all color components of the LED using a Color object
     *
     * @param color The Color object containing RGB values
     */
    public void setColor(Color color) {
        red = color.getRed();
        green = color.getGreen();
        blue = color.getBlue();
    }
}
