package org.llschall.rgbribbon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RgbRibbonTest {
    @Test
    public void versionIsCorrect() {
        assertEquals("0.0.2", RgbRibbon.VERSION);
    }
}
