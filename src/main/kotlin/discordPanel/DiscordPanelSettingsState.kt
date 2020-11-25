package discordPanel

import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.ServiceManager
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage

@State(
        name = "discordPanel.DiscordPanelSettingsState",
        storages = [Storage("DiscordPanelSettings.xml")]
)
class DiscordPanelSettingsState : PersistentStateComponent<DiscordPanelSettingsState.State> {
    companion object {
        fun getInstance(): DiscordPanelSettingsState {
            return ServiceManager.getService(DiscordPanelSettingsState::class.java)
        }
    }

    class State {
        var sessionPath = ""
    }

    private var _state = State()

    override fun getState(): State = _state

    override fun loadState(state: State) {
        _state = state
    }

    fun getSessionPath(): String = _state.sessionPath

    fun setSessionPath(sessionPath: String) {
        _state.sessionPath = sessionPath
    }
}

