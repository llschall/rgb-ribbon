package org.llschall.rgbribbon

import org.llschall.ardwloop.ArdwloopStatus
import org.llschall.ardwloop.IArdwProgram
import org.llschall.ardwloop.value.SerialData
import java.util.concurrent.ArrayBlockingQueue
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicInteger
import java.util.function.Consumer

class ArdwProgram : IArdwProgram {

    var brightness = AtomicInteger()

    var builtInLed = AtomicBoolean(false)
    val leds = ArrayList<RgbLed>()

    private val listeners: MutableList<Consumer<Status>> = ArrayList()

    val queue = ArrayBlockingQueue<String>(1, false);

    init {
        for (i in 0 until 9)
            leds.add(RgbLed())
    }

    override fun ardwSetup(p0: SerialData): SerialData {
        return SerialData()
    }

    override fun ardwLoop(p0: SerialData): SerialData {
        val data = SerialData()

        queue.poll(40, TimeUnit.SECONDS);
        queue.clear()

        if (builtInLed.get())
            data.a.v = 1;
        else
            data.a.v = 0;

        data.b.v = brightness.get()

        data.a.x = leds[0].red
        data.a.y = leds[0].green
        data.a.z = leds[0].blue

        data.b.x = leds[1].red
        data.b.y = leds[1].green
        data.b.z = leds[1].blue

        data.c.x = leds[2].red
        data.c.y = leds[2].green
        data.c.z = leds[2].blue

        data.d.x = leds[3].red
        data.d.y = leds[3].green
        data.d.z = leds[3].blue

        data.e.x = leds[4].red
        data.e.y = leds[4].green
        data.e.z = leds[4].blue

        data.f.x = leds[5].red
        data.f.y = leds[5].green
        data.f.z = leds[5].blue

        data.g.x = leds[6].red
        data.g.y = leds[6].green
        data.g.z = leds[6].blue

        data.h.x = leds[7].red
        data.h.y = leds[7].green
        data.h.z = leds[7].blue

        data.i.x = leds[8].red
        data.i.y = leds[8].green
        data.i.z = leds[8].blue

        return data
    }

    override fun fireStatusChanged(status: ArdwloopStatus) {
        listeners.forEach {
            if (status == ArdwloopStatus.STARTED) {
                it.accept(Status.STARTED)
            }
            if (status == ArdwloopStatus.CONNECTED) {
                it.accept(Status.CONNECTED)
            }
        }
    }

    fun addStatusListener(consumer: Consumer<Status>) {
        listeners.add(consumer)
    }
}