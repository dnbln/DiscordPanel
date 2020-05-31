package discordPanel;

import com.intellij.openapi.wm.ToolWindow;

import javax.swing.*;

public class DiscordPanelImpl {
    private final DiscordPanelViewer viewer;
    public DiscordPanelImpl(ToolWindow toolWindow) {
        viewer = new DiscordPanelViewer(toolWindow);
    }

    public JComponent getContent() {
        return viewer.getContent();
    }
}
