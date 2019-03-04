package Cars;

import java.awt.*;

/**
 * Models the specific Car Saab95.
 */
public class Saab95 extends SmallCar implements ITurbo {

    private boolean turboOn;

    /**
     * Instantiates a Saab95.
     */
    public Saab95() {
        super(2, 125, 0, Color.red, "Saab95");
        turboOn = false;
        stopEngine();
    }

    /**
     * Turns on the turbo vroom vroom
     */
    public void setTurboOn() {
        turboOn = true;
    }

    /**
     * Turns off the turbo :(
     */
    public void setTurboOff() {
        turboOn = false;
    }

    /**
     * @return Returns the speedFactor
     */
    public double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

}
