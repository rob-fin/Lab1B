package Cars;

import java.awt.*;

/**
 * Models a small car. It can be loaded onto car transports.
 */
public abstract class SmallCar extends Car {

    /**
     *
     * @param nrDoors The number of doors of the small car
     * @param enginePower The engine power of the small car
     * @param currentSpeed The current speed of the small car
     * @param color The color of the small car
     * @param modelName The model name of the small car
     */
    public SmallCar(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName) {
        super(nrDoors, enginePower, currentSpeed, color, modelName);

    }

    /**
     * This method will check that the car is relatively close to the
     * CarTransport it should enter and that is is not currently loaded
     *
     * @param carTransport The CarTransport which the loadable will enter
     */
    public void enter(CarTransport carTransport) {
        if (Math.sqrt(Math.pow(carTransport.getCurrentPosition().x - getCurrentPosition().x, 2)
                + Math.pow(carTransport.getCurrentPosition().y - getCurrentPosition().y, 2)) <= 10 &&
                !super.getLoaded()) {
            carTransport.loadCar(this);
            super.setLoaded(true);
        }
    }
}
