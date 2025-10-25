package org.llschall.rgbribbon

import org.llschall.ardwloop.ArdwloopStarter

class RgbRibbonImpl(ledCount: Int) {

    companion object {
        @JvmField
        var VERSION: String = "0.0.3"
    }

    val program = ArdwProgram()

    fun start() {
        ArdwloopStarter.get().start(program, 9600)
    }

    fun updateBrightness(brightness: Int) {
        program.brightness.set(brightness)
    }

    fun toggleBuiltInLed() {
        val get = program.builtInLed.get()
        program.builtInLed.set(!get)
    }

    fun updateRed(value: Int) {
        program.red.set(value)
    }

    fun updateGreen(value: Int) {
        program.green.set(value)
    }

    fun updateBlue(value: Int) {
        program.blue.set(value)
    }
}
