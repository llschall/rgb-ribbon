/*
 * RGB Ribbon version 0.0.5
 *
 * Setup instructions are available on
 * https://github.com/llschall/rgb-ribbon
 */

// Use Ardwloop 0.3.7
#include <Ardwloop.h>

// Use FastLED by Daniel Garcia
// Version 3.10.3
#include <FastLED.h>

// How many leds in your strip?
#define NUM_LEDS 9

#define DATA_PIN 3

// Define the array of leds
CRGB leds[NUM_LEDS];

void setup() {

  pinMode(LED_BUILTIN, OUTPUT);
  digitalWrite(LED_BUILTIN, HIGH);

  FastLED.setBrightness(40);

  FastLED.addLeds<NEOPIXEL, DATA_PIN>(leds, NUM_LEDS);

  for (int i = 0; i < NUM_LEDS; i++) {
    leds[i] = CRGB(0, 20, 20);
  }
  FastLED.show();

  // Here the baud value should be set to the same value as on the Java side
  ardw_setup(BAUD_9600);

  for (int i = 0; i < NUM_LEDS; i++) {
    leds[i] = CRGB(0, 0, 20);
  }

  FastLED.show();
}

void loop() {
  ardw_loop();

  int v = ardw_r()->a.v;

  if (v == 1) {
    digitalWrite(LED_BUILTIN, HIGH);
  } else {
    digitalWrite(LED_BUILTIN, LOW);
  }

  int brightness = ardw_r()->b.v;
  FastLED.setBrightness(brightness);

  // Set the color of all leds
  for (int i = 0; i < 9; i++) {
    int r = ardw_array(3 * i);
    int g = ardw_array(3 * i + 1);
    int b = ardw_array(3 * i + 2);
    leds[i] = CRGB(r, g, b);
  }

  FastLED.show();

  delay(99);
}
