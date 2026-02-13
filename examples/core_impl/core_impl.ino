/*
 * **********************************
 * RGB Ribbon ready to upload example
 * **********************************
 *
 * Setup instructions are available on
 * https://github.com/llschall/rgb-ribbon
 */

// Use FastLED by Daniel Garcia
// Version 3.10.3
#include <FastLED.h>

// Use Ardwloop by Laurent Schall
// Version 0.3.9
#include <Ardwloop.h>

#include <RGBRibbon.h>

void setup() {
  rgb_setup();
}

void loop() {
  rgb_loop();
}