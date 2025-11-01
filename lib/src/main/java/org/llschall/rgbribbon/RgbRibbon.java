package org.llschall.rgbribbon;

public class RgbRibbon {

    public static String VERSION = RgbRibbonImpl.VERSION;

    final RgbRibbonImpl impl;

    public RgbRibbon(int brightness) {
        impl = new RgbRibbonImpl();
    }

    public void start() {
        impl.start();
    }

    public void toggleBuiltInLed() {
        impl.toggleBuiltInLed();
    }

    public void publish() {
        impl.publish();
    }

    public RgbLed getLed(int i) {
        return impl.getLed(i);
    }

    public void setBrightness(int brightness) {
        impl.updateBrightness(brightness);
    }
}
