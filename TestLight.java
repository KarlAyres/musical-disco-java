public class TestLight {
    public static void main(String[] args) {

        // Create a light object with brightness: high, switch: on, colour: orange
        Light light1 = new Light();
        light1.setLightBrightness(3);
        light1.setLightSwitch(true);
        light1.setLightColour("Orange");

        // Display object description
        System.out.println("\nLight 1\n________\n\n" + light1.toString());

        // Create a light object with brightness, medium, switch: off, colour: green
        Light light2 = new Light();
        light2.setLightBrightness(2);
        light2.setLightSwitch(false);
        light2.setLightColour("Green");

        // Display object description
        System.out.println("\nLight 2\n________\n\n" + light2.toString());

        // Create a default light object
        Light light3 = new Light();

        // Display object description
        System.out.println("\nLight 3\n________\n\n" + light3.toString());

        // Create an abnormal light object, light reverts to default
        Light light4 = new Light();
        light2.setLightBrightness(4);
        light2.setLightSwitch(false);
        light2.setLightColour("Yellow");

        // Display object description
        System.out.println("\nLight 4\n________\n\n" + light4.toString());

        // Create an abnormal light object, light reverts to default
        Light light5 = new Light();
        light2.setLightBrightness(3);
        light2.setLightSwitch(true);
        light2.setLightColour("Aqua");

        // Display object description
        System.out.println("\nLight 5\n________\n\n" + light5.toString());
    }
}
class Light {

    // Three brightness constants: LOW, MEDIUM, HIGH - default LOW
    final int LOW = 1;
    final int MEDIUM = 2;
    final int HIGH = 3;

    // Array of colour constants
    final String[] COLOURS_ARRAY = {"Red", "Orange", "Yellow", "Green", "Blue", "Indigo", "Violet"};

    // Default state of light brightness
    private int lightBrightness = LOW;

    // Default state of light switch
    private boolean lightSwitch = false;

    // Default state of light colour
    private String lightColour = "Red";

    // Construct no-arg light
    public Light() {
    }

    // Construct light object with specified brightness, switch-state, and colour
    public Light(int newLightBrightness, boolean newLightSwitch, String newLightColour) {
        lightBrightness = newLightBrightness;
        lightSwitch = newLightSwitch;
        lightColour = newLightColour;
    }

    // Set a new brightness for the light
    public void setLightBrightness(int newLightBrightness) {
        if (newLightBrightness == LOW) {
            lightBrightness = LOW;
        }
        else if (newLightBrightness == MEDIUM) {
            lightBrightness = MEDIUM;
        }
        else if (newLightBrightness == HIGH) {
            lightBrightness = HIGH;
        }
    }

    // Set lightSwitch to on or off
    public void setLightSwitch(boolean newLightSwitch) {
        if (newLightSwitch == false) {
            lightSwitch = false;
        }
        else if (newLightSwitch == true) {
            lightSwitch = true;
        }
    }

    // Set lightColour
    public void setLightColour(String newLightColour) {
        if (newLightColour == COLOURS_ARRAY[0]) {
            lightColour = COLOURS_ARRAY[0];
        }
        else if (newLightColour == COLOURS_ARRAY[1]) {
            lightColour = COLOURS_ARRAY[1];
        }
        else if (newLightColour == COLOURS_ARRAY[2]) {
            lightColour = COLOURS_ARRAY[2];
        }
        else if (newLightColour == COLOURS_ARRAY[3]) {
            lightColour = COLOURS_ARRAY[3];
        }
        else if (newLightColour == COLOURS_ARRAY[4]) {
            lightColour = COLOURS_ARRAY[4];
        }
        else if (newLightColour == COLOURS_ARRAY[5]) {
            lightColour = COLOURS_ARRAY[5];
        }
        else if (newLightColour == COLOURS_ARRAY[6]) {
            lightColour = COLOURS_ARRAY[6];
        }

    }

    // Get light brightness
    public int getLightBrightness() {
        return lightBrightness;
    }

    // Get light switch state
    public boolean getLightSwitch() {
        return lightSwitch;
    }

    // Get light colour
    public String getLightColour() {
        return lightColour;
    }

    // Modify toString method to display light status
    public String toString() {
        String lightStatus = null;
        if (getLightSwitch() == true) {
            lightStatus = "Light: On\nBrightness: " + getLightBrightness() + "\nColour: "
                    + getLightColour();
        }
        else if (getLightSwitch() == false) {
            lightStatus = "Light: Off\nColour: " + getLightColour();

        }
        return lightStatus;
    }

}
