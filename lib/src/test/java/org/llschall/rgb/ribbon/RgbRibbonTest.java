package org.llschall.rgb.ribbon;

import org.junit.jupiter.api.Test;

import java.awt.Color;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RgbRibbonTest {
    @Test
    public void versionIsCorrect() {
        assertEquals("0.1.5", RgbRibbon.VERSION);
    }

    @Test
    public void awtColorCanBeSet() {
        RgbRibbon ribbon = new RgbRibbon();
        RgbLed led = ribbon.getLed(0);

        Color color = new Color(100, 200, 30);
        led.setColor(color);

        assertEquals(100, led.red);
        assertEquals(200, led.green);
        assertEquals(30, led.blue);
    }

}
