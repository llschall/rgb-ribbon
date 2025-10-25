package org.llschall.rgbribbon

import org.llschall.ardwloop.IArdwProgram
import org.llschall.ardwloop.value.SerialData
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicInteger

class ArdwProgram : IArdwProgram {

    var brightness = AtomicInteger()
    var builtInLed = AtomicBoolean(false)

    var red = AtomicInteger()
    var green = AtomicInteger()
    var blue = AtomicInteger()

    override fun ardwSetup(p0: SerialData): SerialData {
        return SerialData()
    }

    override fun ardwLoop(p0: SerialData): SerialData {
        val data = SerialData()
        if (builtInLed.get())
            data.a.v = 1;
        else
            data.a.v = 0;

        data.b.v = brightness.get()

        data.a.x = red.get()
        data.a.y = green.get()
        data.a.z = blue.get()

        return data
    }

}