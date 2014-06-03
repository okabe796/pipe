package pipe.actions.gui;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class ImmediateTransitionAction extends TransitionAction {


    public ImmediateTransitionAction(PipeApplicationModel applicationModel) {
        super("Immediate transition", "Add an immediate transition (alt-I)", KeyEvent.VK_I, InputEvent.ALT_DOWN_MASK,
                applicationModel);
    }

    @Override
    protected boolean isTimed() {
        return false;
    }
}