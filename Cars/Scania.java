package Cars;

import CarSupplements.*;
import java.awt.*;

public class Scania extends Car {
    private TruckBed wagon;

    public Scania() {
        super(4, 700, 0, Color.white, "Scania");
        startEngine();
        wagon = new TruckBed();
    }

    /**
     *
     * @return Returns the trucks current wagon
     */
    public TruckBed getWagon(){
        return this.wagon;
    }

    /**
     * Calculates the speed factor which is just the engine power.
     * @return returns the speed factor.
     */
    public double speedFactor() {
        return getEnginePower();
    }

    /**
     * Sets the speed for the truck and the wagon
     * @param speed Speed to set
     */
    @Override
    public void setCurrentSpeed(double speed) {
        super.setCurrentSpeed(speed);
        wagon.setTruckSpeed(speed);
    }

}
