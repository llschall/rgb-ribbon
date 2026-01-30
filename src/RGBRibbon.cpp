/*
 * RGB Ribbon version 0.1.3
 *
 * Setup instructions are available on
 * https://github.com/llschall/rgb-ribbon
 */

#include <RGBRibbon.h>

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

// Effect material
uint8_t pos = 0;
bool toggle = false;

void rgb_setup() {

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

void rgb_loop() {
  ardw_loop();

  int v = ardw_r()->a.v;
  int w = ardw_r()->a.w;

  if (v == 1) {
    digitalWrite(LED_BUILTIN, HIGH);
  } else {
    digitalWrite(LED_BUILTIN, LOW);
  }

  if (w == 1) {
    for(int i = 0; i < 100; i++)
    playEffect();
  } else {
    displayArray();
  }
}

void displayArray() {
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


void playEffect() {
  FastLED.setBrightness(255);
  // Add a bright pixel that moves
  leds[pos] = CHSV(pos * 2, 255, 255);

  // Blur the entire strip
  blur1d(leds, NUM_LEDS, 172);
  fadeToBlackBy(leds, NUM_LEDS, 16);

  FastLED.show();
  // Move the position of the dot
  if (toggle) {
    pos = (pos + 1) % NUM_LEDS;
  }
  toggle = !toggle;
  delay(30);
}
