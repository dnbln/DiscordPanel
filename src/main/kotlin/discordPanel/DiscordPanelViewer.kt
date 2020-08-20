package discordPanel

import com.intellij.openapi.wm.ToolWindow
import com.intellij.ui.jcef.JBCefBrowser
import com.intellij.ui.jcef.JBCefCookie
import java.awt.event.FocusEvent
import java.awt.event.FocusListener
import javax.swing.JComponent

class DiscordPanelViewer(window: ToolWindow) {
    @JvmField
    val jbrowser: JBCefBrowser = JBCefBrowser("https://discord.com/app")
    val content: JComponent
        get() = jbrowser.component

    init {
        window.title = "Discord Panel"
        window.component.addFocusListener(object : FocusListener {
            override fun focusGained(focusEvent: FocusEvent) {
                for (listener in jbrowser.component.focusListeners) listener.focusGained(focusEvent)
            }

            override fun focusLost(focusEvent: FocusEvent) {
                for (listener in jbrowser.component.focusListeners) listener.focusLost(focusEvent)
            }
        })
    }
}