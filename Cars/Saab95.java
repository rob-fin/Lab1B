package Cars;

import CarSupplements.*;
import java.awt.*;

public class Saab95 extends SmallCar {

    private boolean turboOn;

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
     *
     * @return Returns the speedfactor
     */
    public double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

}
