package discordPanel

import com.intellij.openapi.options.ConfigurationException
import com.intellij.openapi.options.SearchableConfigurable
import org.jetbrains.annotations.Nls
import java.io.File
import javax.swing.JComponent

class DiscordPanelConfigurable : SearchableConfigurable {
    private var discordPanelSettingsComponent: DiscordPanelSettingsComponent? = null

    @Nls(capitalization = Nls.Capitalization.Title)
    override fun getDisplayName(): String {
        return "Discord Panel"
    }

    override fun getPreferredFocusedComponent(): JComponent? {
        return discordPanelSettingsComponent?.getPreferredFocusedComponent()
    }

    override fun getId(): String = "discord-panel"

    override fun createComponent(): JComponent {
        val component = DiscordPanelSettingsComponent()
        discordPanelSettingsComponent = component
        return component.getPanel()
    }

    override fun isModified(): Boolean {
        val settings: DiscordPanelSettingsState = DiscordPanelSettingsState.getInstance()
        return discordPanelSettingsComponent!!.getSessionPath() != settings.getSessionPath()
    }

    @Throws(ConfigurationException::class)
    override fun apply() {
        val settings: DiscordPanelSettingsState = DiscordPanelSettingsState.getInstance()
        val sessionPathString = discordPanelSettingsComponent!!.getSessionPath()
        val sessionPath = File(sessionPathString)
        if (!sessionPath.exists())
            throw ConfigurationException("Discord session path does not point to an existent directory")
        if (!sessionPath.isDirectory)
            throw ConfigurationException("Discord session path does not point to a directory")
        settings.setSessionPath(sessionPathString)
    }

    override fun reset() {
        val settings: DiscordPanelSettingsState = DiscordPanelSettingsState.getInstance()
        val sessionPath = settings.getSessionPath()
        discordPanelSettingsComponent!!.setSessionPath(sessionPath)
    }

    override fun disposeUIResources() {
        discordPanelSettingsComponent = null
    }
}