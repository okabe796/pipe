package pipe.actions.gui;

import pipe.utilities.gui.GuiUtils;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ZoomOutAction extends GuiAction {

    public ZoomOutAction(ZoomManager zoomManager) {
        super("Zoom out", "Zoom out by 10% ", KeyEvent.VK_MINUS, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask());
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        GuiUtils.displayErrorMessage(null,
                "Zooming in/out is currently not supported in this version.\n Please file an issue if it is particularly important to you.");

        //        if (zoomManager.canZoomOut()) {
        //            zoomManager.zoomOut();
        //        }
    }
}
