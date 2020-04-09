package com.burusutazu.controller;

import com.burusutazu.model.MouseHoldDown;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.awt.*;

/**
 * Handles listening for user input and acts upon that input.
 *
 * @author Brandon Eugene Walker [Burusutazu]
 * @version March 18th, 2020.
 */
public class SimpleMouseController implements NativeKeyListener {

    private MouseHoldDown mouseHoldDown;
    private static final int ALT_KEY_CODE = 56;
    private static final int END_KEY_CODE = 3663;


    /**
     * Creates a new instance of a SimpleMouseController.
     *
     * @throws AWTException Thrown is the operatoring system is blocking or does not support simulating key presses.
     * @precondition none
     * @postcondiiton the controller is created
     */
    public SimpleMouseController() throws AWTException {
        this.mouseHoldDown = new MouseHoldDown();
    }

    /**
     * Fires when a key is typed, not used by this program.
     *
     * @param nativeKeyEvent The event firing.
     */
    public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {
        //NOT USED
    }

    /**
     * Fires when a key is pressed. If the pressed key is the alt key then the mouse action is toggled.
     *
     * @param nativeKeyEvent The event fired and all its information.
     * @precondition none
     * @postcondition if alt key mouse is toggled
     */
    public void nativeKeyPressed(NativeKeyEvent nativeKeyEvent) {
        int pressedKeyCode = nativeKeyEvent.getKeyCode();

        if (pressedKeyCode == ALT_KEY_CODE) {
            System.out.println("Alt key press detected.");
            boolean rightMouseState = this.mouseHoldDown.toggleRightMouseButton();
            System.out.println("Right mouse button state is now: " + rightMouseState + ".");
        } else if (pressedKeyCode == END_KEY_CODE) {
            System.out.println("Aborting mouse hold down...");
            this.mouseHoldDown.abortRightMousePress();
            System.exit(0);
        }

    }

    /**
     * Fires when a key is released, not used by this program.
     *
     * @param nativeKeyEvent The event firing.
     */
    public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {
        //NOT USED
    }


}
