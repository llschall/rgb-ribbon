package org.llschall.rgbribbon;

public class RgbRibbon {

    public static String VERSION = RgbRibbonImpl.VERSION;

    final int ledCount;

    public RgbRibbon(int ledCount) {
        this.ledCount = ledCount;
    }

    public RgbLed getLed(int i) {
        return new RgbLed();
    }

    public void setBrightness(int brightness) {}

    public void flush() {}

}
