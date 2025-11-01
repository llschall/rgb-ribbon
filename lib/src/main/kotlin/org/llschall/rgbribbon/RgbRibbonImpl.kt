package org.llschall.rgbribbon

import org.llschall.ardwloop.ArdwloopStarter
import java.util.function.Consumer

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
        program.queue.offer("")
    }

    fun updateBrightness(brightness: Int) {
        program.brightness.set(brightness)
    }

    fun toggleBuiltInLed() {
        val get = program.builtInLed.get()
        program.builtInLed.set(!get)
        publish()
    }

    fun getLed(i: Int): RgbLed {
        return program.leds[i]
    }

    fun addStatusListener(consumer: Consumer<Status>) {
        program.addStatusListener(consumer)
    }
}
