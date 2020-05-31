package discordPanel;

import com.intellij.openapi.wm.ToolWindow;
import com.intellij.ui.jcef.JBCefBrowser;
import org.cef.browser.CefBrowser;
import org.cef.browser.CefFrame;
import org.cef.callback.CefAuthCallback;
import org.cef.callback.CefRequestCallback;
import org.cef.handler.CefLoadHandler;
import org.cef.handler.CefRequestHandler;
import org.cef.handler.CefResourceHandler;
import org.cef.misc.BoolRef;
import org.cef.misc.StringRef;
import org.cef.network.CefRequest;
import org.cef.network.CefResponse;
import org.cef.network.CefURLRequest;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

@SuppressWarnings("UnstableApiUsage")
public class DiscordPanelViewer {
    private final JBCefBrowser jbrowser;

    public DiscordPanelViewer(ToolWindow window) {
        jbrowser = new JBCefBrowser("https://discord.com/app");
        window.setTitle("Discord Panel");
        window.getComponent().addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent focusEvent) {
                for(FocusListener listener : jbrowser.getComponent().getFocusListeners())
                    listener.focusGained(focusEvent);
            }

            @Override
            public void focusLost(FocusEvent focusEvent) {
                for(FocusListener listener : jbrowser.getComponent().getFocusListeners())
                    listener.focusLost(focusEvent);
            }
        });
    }

    public JComponent getContent() {
        return jbrowser.getComponent();
    }
}
