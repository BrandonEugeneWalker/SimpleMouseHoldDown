package com.burusutazu;

import com.burusutazu.controller.SimpleMouseController;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.WARNING);
        logger.setUseParentHandlers(false);
        SimpleMouseController simpleMouseController = null;

        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException nhe) {
            System.err.println("There was an error registering the native hook.");
            System.err.println(nhe.getMessage());
            System.exit(1);
        }

        try {
            simpleMouseController = new SimpleMouseController();
            System.out.println("Now listening for key presses.");
            System.out.println("Press the ALT key to toggle the right mouse button.");
            System.out.println("Press END key to exit the program.");
            GlobalScreen.addNativeKeyListener(simpleMouseController);
        } catch (AWTException atwe) {
            System.err.println(atwe.getMessage());
            atwe.printStackTrace();
        }

        Runnable exitHookRunnable = new Runnable() {
            public void run() {
                try {
                    GlobalScreen.unregisterNativeHook();
                } catch (NativeHookException nhe) {
                    System.err.println(nhe.getMessage());
                }

            }
        };

        Thread exitThread = new Thread(exitHookRunnable);
        Runtime.getRuntime().addShutdownHook(exitThread);


    }
}
