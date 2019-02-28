package Cars;

import java.awt.*;

/**
 * Models the specific Car Volvo240.
 */
public class Volvo240 extends SmallCar {

    private final static double trimFactor = 1.25;

    /**
     * Instantiates a new Volvo240
     */
    public Volvo240() {
        super(4, 100, 0, Color.black, "Volvo240");
        stopEngine();
    }

    /**
     * @return Returns the speedFactor
     */
    public double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }

}
