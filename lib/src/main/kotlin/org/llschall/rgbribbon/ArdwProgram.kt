package org.llschall.rgbribbon

import org.llschall.ardwloop.ArdwloopStarter
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

    override fun getArraySize(): Int {
        ArdwloopStarter.get().setLogLevel(1)
        return 27
    }

    override fun ardwSetup(p0: SerialData): SerialData {
        val data = SerialData()
        data.array = Array(27) { 0 }
        return data
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

        data.array = Array(27) { 0 }

        for (i in 0 until 9) {
            val led = leds[i]
            data.array[3 * i] = led.red
            data.array[3 * i + 1] = led.green
            data.array[3 * i + 2] = led.blue
        }
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