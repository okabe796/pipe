/*
 * Created on 07-Mar-2004
 */
package pipe.actions.gui;

import pipe.gui.PIPEConstants;

import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoableEdit;
import java.net.URL;


/**
 * GuiAction class
 *
 * @author Maxim and others
 *         <p/>
 *         Handles loading icon based on action name and setting up other stuff
 *         <p/>
 *         Toggleable actions store the toggle state in a way that allows ChangeListeners
 *         to be notified of changes
 */
public abstract class GuiAction extends AbstractAction {

    public static final String SELECTED = "selected";

    protected UndoableEditListener listener;


    /**
     * @param name      image name
     * @param tooltip   tooltip message
     * @param key       {@link java.awt.event.KeyEvent} key
     * @param modifiers e.g. ctrl/shift obtained from {@link java.awt.event.InputEvent}
     */
    protected GuiAction(String name, String tooltip, int key, int modifiers) {
        this(name, tooltip);

        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(key, modifiers));
    }

    protected GuiAction(String name, String tooltip) {
        super(name);
        URL iconURL = this.getClass().getResource(PIPEConstants.IMAGE_PATH + name + ".png");
        if (iconURL != null) {
            putValue(SMALL_ICON, new ImageIcon(iconURL));
        }

        if (tooltip != null) {
            putValue(SHORT_DESCRIPTION, tooltip);
        }
    }

    protected GuiAction(String name, String tooltip, String keystroke, boolean toggleable) {
        this(name, tooltip, keystroke);
        putValue(SELECTED, Boolean.FALSE);
    }

    protected GuiAction(String name, String tooltip, String keystroke) {

        this(name, tooltip);
        if (keystroke != null) {
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(keystroke));
        }
    }

    // Set the UndoableEditListener.
    public void addUndoableEditListener(UndoableEditListener l) {
        listener = l; //TODO: Should ideally throw an exception if listener != null
    }

    // Remove the UndoableEditListener.
    public void removeUndoableEditListener(UndoableEditListener l) {
        listener = null;
    }

    public boolean isSelected() {
        Boolean b = (Boolean) getValue(SELECTED);

        return b != null && b;
    }


    public void setSelected(boolean selected) {
        Boolean b = (Boolean) getValue(SELECTED);

        if (b != null) {
            putValue(SELECTED, Boolean.valueOf(selected));
        }
    }

    protected void registerUndoEvent(UndoableEdit edit) {
        if (listener != null) {
            listener.undoableEditHappened(new UndoableEditEvent(this, edit));
        }
    }

}
