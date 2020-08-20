package discordPanel

import com.intellij.openapi.wm.ToolWindow
import javax.swing.JComponent

class DiscordPanelImpl(toolWindow: ToolWindow?) {
    private val viewer: DiscordPanelViewer = DiscordPanelViewer(toolWindow!!)
    val content: JComponent
        get() = viewer.content

}