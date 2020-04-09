package com.burusutazu.model;

import java.awt.*;
import java.awt.event.InputEvent;

/**
 * This class handles toggling holding down the right mouse button (button 3).
 *
 * @author Brandon Eugene Walker [Burusutazu]
 * @version March 18th, 2020
 */
public class MouseHoldDown {

    private boolean isHeldDown;
    private Robot mouseRobot;

    /**
     * Creates a new instance of the MouseHoldDown class.
     *
     * @throws AWTException Thrown when OS does not support simulating inputs or has blocked them.
     * @precondition none
     * @postcondition the MouseHoldDown is created.
     */
    public MouseHoldDown() throws AWTException {
        this.isHeldDown = false;
        this.mouseRobot = new Robot();
    }

    /**
     * Toggles the right mouse button from holding to not holding depending on the current state.
     *
     * @return the state of the click
     * @precondition if held down release, else press
     */
    public synchronized boolean toggleRightMouseButton() {
        if (this.isHeldDown) {
            this.releaseRightMouseButton();
        } else {
            this.pressRightMouseButton();
        }
        return this.isHeldDown;
    }

    /**
     * Aborts the mouse click if needed.
     *
     * @precondition the right mouse button must be pressed
     * @postcondition the mouse press is released
     */
    public synchronized void abortRightMousePress() {
        if (this.isHeldDown) {
            this.releaseRightMouseButton();
        }
    }

    private void pressRightMouseButton() {
        this.mouseRobot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
        this.isHeldDown = true;
    }

    private void releaseRightMouseButton() {
        this.mouseRobot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
        this.isHeldDown = false;
    }


}
