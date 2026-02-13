package org.llschall.rgb.ribbon

import org.llschall.ardwloop.ArdwloopStarter
import java.awt.SystemTray
import java.awt.Toolkit
import java.awt.TrayIcon
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import java.util.function.Consumer

class RgbRibbonImpl(brightness: Int) {

    companion object {
        @JvmField
        var VERSION: String = "0.1.5"
    }

    val program = ArdwProgram(brightness)

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
        program.playEffect.incrementAndGet()
        publish()
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
        if (resource == null) {
            System.err.println("Resource /tray.png not found, tray icon won't be displayed")
            return
        }
        val image = Toolkit.getDefaultToolkit().createImage(resource)
        val icon = TrayIcon(image)
        icon.setImageAutoSize(true)
        icon.setToolTip("rgb-ribbon")

        // left-click handler: toggle the built-in LED and publish the change
        icon.addMouseListener(object : MouseAdapter() {
            override fun mouseClicked(e: MouseEvent) {
                if (e.button == MouseEvent.BUTTON1) {
                    startEffect()
                }
                if (e.button == MouseEvent.BUTTON3) {
                    toggleBuiltInLed()
                }
            }
        })

        try {
            val tray = SystemTray.getSystemTray()
            tray.add(icon)
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }
}
