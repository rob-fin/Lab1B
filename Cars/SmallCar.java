package Cars;

import CarSupplements.*;
import java.awt.*;

public abstract class SmallCar extends Car {

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
