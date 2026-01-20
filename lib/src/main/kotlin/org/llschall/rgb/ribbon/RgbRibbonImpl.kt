package org.llschall.rgb.ribbon

import org.llschall.ardwloop.ArdwloopStarter
import java.awt.SystemTray
import java.awt.Toolkit
import java.awt.TrayIcon
import java.util.function.Consumer

class RgbRibbonImpl() {

    companion object {
        @JvmField
        var VERSION: String = "0.0.7"
    }

    val program = ArdwProgram()

    fun start(retryConnection: Boolean, displayTrayIcon: Boolean) {
        if (displayTrayIcon) displayTrayIcon()

        ArdwloopStarter.get().setRetryConnection(retryConnection)
        ArdwloopStarter.get().start(program, 9600)
    }

    fun start() {
        start(true, false)
    }

    fun publish() {
        program.queue.offer("")
    }

    fun updateBrightness(brightness: Int) {
        program.brightness.set(brightness)
    }

    fun startEffect() {
        program.playEffect.set(true)
    }

    fun stopEffect() {
        program.playEffect.set(false)
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

    fun displayTrayIcon() {
        val resource = RgbRibbonImpl::class.java.getResource("/tray.png")
        val image = Toolkit.getDefaultToolkit().createImage(resource)
        val icon = TrayIcon(image)
        icon.setImageAutoSize(true)
        icon.setToolTip("rgb-ribbon")
        try {
            val tray = SystemTray.getSystemTray()
            tray.add(icon)
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }
}
