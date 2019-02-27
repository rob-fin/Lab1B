package Cars;

import CarSupplements.TruckBed;

import java.awt.*;

/**
 * Models a Scania truck.
 */
public class Scania extends Car implements ITruckBed {
    private TruckBed wagon;

    /**
     * Instantiates a Scania.
     */
    public Scania() {
        super(4, 350, 0, Color.white, "Scania");
        wagon = new TruckBed();
        stopEngine();
    }
    @Override
    public void startEngine() {
        if (wagon.getWagonAngle() == 0)
            super.startEngine();
        else
            System.out.println("Cannot start engine when truckbed is up");
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
        return getEnginePower() * 0.003;
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

    /**
     * Overrided because we need to check the wagon angle to see if it's all the way down
     * @param amount Specifies how much the speed should increase by [0,1]
     */
    @Override
    public void gas(double amount) {
        if (this.wagon.getWagonAngle() == 0)
       super.gas(amount);
    }

}
