package discordPanel

import com.intellij.openapi.fileChooser.FileChooserDescriptor
import com.intellij.openapi.ui.TextBrowseFolderListener
import com.intellij.openapi.ui.TextFieldWithBrowseButton
import com.intellij.ui.components.JBLabel
import com.intellij.util.ui.FormBuilder
import javax.swing.JComponent
import javax.swing.JPanel

class DiscordPanelSettingsComponent {
    private var mainPanel: JPanel
    private val discordSessionPath = TextFieldWithBrowseButton()

    init {
        discordSessionPath.addBrowseFolderListener(TextBrowseFolderListener(FileChooserDescriptor(false, true, false, false, false, false)))
        mainPanel = FormBuilder.createFormBuilder()
                .addLabeledComponent(JBLabel("Discord session cache path: "), discordSessionPath, 1, false)
                .addComponentFillVertically(JPanel(), 0)
                .panel
    }

    fun getPanel(): JPanel {
        return mainPanel
    }

    fun getPreferredFocusedComponent(): JComponent {
        return discordSessionPath
    }

    fun getSessionPath(): String = discordSessionPath.text
    fun setSessionPath(sessionPath: String?) {
        discordSessionPath.text = sessionPath ?: ""
    }
}
