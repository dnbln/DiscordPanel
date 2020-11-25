package discordPanel

import com.intellij.openapi.fileChooser.FileChooser
import com.intellij.openapi.fileChooser.FileChooserDescriptor
import com.intellij.openapi.util.IconLoader
import com.intellij.openapi.vfs.VfsUtil
import com.intellij.openapi.wm.ToolWindow
import com.intellij.ui.jcef.JBCefApp
import com.intellij.ui.jcef.JBCefBrowser
import com.intellij.ui.jcef.JBCefClient
import com.jetbrains.cef.JCefAppConfig
import org.cef.CefApp
import org.cef.CefSettings
import java.awt.event.FocusEvent
import java.awt.event.FocusListener
import javax.swing.JComponent

class DiscordPanelViewer(window: ToolWindow) {
    companion object {
        val ICON = IconLoader.getIcon("/icons/discord.svg")
    }

    @JvmField
    val jbrowser: JBCefBrowser
    val content: JComponent
        get() = jbrowser.component

    init {
        val cachePath = DiscordPanelSettingsState.getInstance().getSessionPath()
        if (cachePath != "") {
            val realCefSettings = JCefAppConfig.getInstance().cefSettings
            realCefSettings.cache_path = cachePath
            realCefSettings.persist_session_cookies = true
        }
        jbrowser = JBCefBrowser("https://discord.com/app")
    }

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