package org.llschall.rgbribbon

import org.llschall.ardwloop.ArdwloopStarter

class RgbRibbonImpl() {

    companion object {
        @JvmField
        var VERSION: String = "0.0.4"
    }

    val program = ArdwProgram()

    fun start() {
        ArdwloopStarter.get().start(program, 9600)
    }

    fun publish() {
        program.queue.add("")
    }

    fun updateBrightness(brightness: Int) {
        program.brightness.set(brightness)
    }

    fun toggleBuiltInLed() {
        val get = program.builtInLed.get()
        program.builtInLed.set(!get)
    }

    fun getLed(i: Int): RgbLed {
        return program.leds[i]
    }
}
