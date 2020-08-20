package discordPanel

import com.intellij.openapi.util.IconLoader
import com.intellij.openapi.wm.ToolWindow
import com.intellij.ui.jcef.JBCefBrowser
import java.awt.event.FocusEvent
import java.awt.event.FocusListener
import javax.swing.JComponent

class DiscordPanelViewer(window: ToolWindow) {
    companion object {
        val ICON = IconLoader.getIcon("/icons/discord.svg")
    }

    @JvmField
    val jbrowser: JBCefBrowser = JBCefBrowser("https://discord.com/app")
    val content: JComponent
        get() = jbrowser.component

    init {
        window.title = "Discord Panel"
        window.setIcon(ICON)
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