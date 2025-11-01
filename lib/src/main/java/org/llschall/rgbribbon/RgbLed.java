package org.llschall.rgbribbon;

import java.awt.Color;

public class RgbLed {

    int red;
    int green;
    int blue;

    public void setRed(int value) {
        red = value;
    }

    public void setGreen(int value) {
        green = value;
    }

    public void setBlue(int value) {
        blue = value;
    }

    public void setColor(Color color) {
        red = color.getRed();
        green = color.getGreen();
        blue = color.getBlue();
    }
}
