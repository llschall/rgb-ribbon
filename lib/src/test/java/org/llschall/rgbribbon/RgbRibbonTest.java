package org.llschall.rgbribbon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RgbRibbonTest {
    @Test
    public void versionIsCorrect() {
        assertEquals("0.0.4", RgbRibbon.VERSION);
    }
}
