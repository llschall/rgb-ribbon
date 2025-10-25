package org.llschall.rgbribbon;

public class RgbLed {

    RgbLed(RgbRibbonImpl impl) {
        this.impl = impl;
    }

    final RgbRibbonImpl impl;

    public void setRed(int value) {
        impl.updateRed(value);
    }

    public void setGreen(int value) {
        impl.updateGreen(value);
    }

    public void setBlue(int value) {
        impl.updateBlue(value);
    }
}
