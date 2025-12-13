/*
 * RGB Ribbon version 0.0.6
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
  leds[0] = CRGB(ardw_r()->a.x, ardw_r()->a.y, ardw_r()->a.z);
  leds[1] = CRGB(ardw_r()->b.x, ardw_r()->b.y, ardw_r()->b.z);
  leds[2] = CRGB(ardw_r()->c.x, ardw_r()->c.y, ardw_r()->c.z);
  leds[3] = CRGB(ardw_r()->d.x, ardw_r()->d.y, ardw_r()->d.z);
  leds[4] = CRGB(ardw_r()->e.x, ardw_r()->e.y, ardw_r()->e.z);
  leds[5] = CRGB(ardw_r()->f.x, ardw_r()->f.y, ardw_r()->f.z);
  leds[6] = CRGB(ardw_r()->g.x, ardw_r()->g.y, ardw_r()->g.z);
  leds[7] = CRGB(ardw_r()->h.x, ardw_r()->h.y, ardw_r()->h.z);
  leds[8] = CRGB(ardw_r()->i.x, ardw_r()->i.y, ardw_r()->i.z);

  FastLED.show();

  delay(99);
}
