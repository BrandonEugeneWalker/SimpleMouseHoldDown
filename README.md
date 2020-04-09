## SimpleMouseHoldDown
A simple program for holding down the right mouse key.

**DESCRIPTION:**

Makes use of jnativehook to listen for key presses when the window is not active.
When left alt is pressed the right mouse button is toggled pressed or unpressed depending on its current state. 
Pressing the END key will exit the program and abort any current mouse presses.

**CONTROLS:**

*Left* ALT: Toggles holding down the right mouse button.
END: Ends the program.

**USES:**

Minecraft

**Running:**

Allow the jar file to run in its properties then run in the directory the jar is located:
java -jar SimpleMouseHoldDown.jar

If the program crashes when you run it then your operating system does not support jnativehook.
Tested and runs on Pop!_OS 19.10
