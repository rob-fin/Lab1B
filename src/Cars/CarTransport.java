package Cars;

import CarSupplements.CarTrailer;

import java.awt.*;

/**
 * Models a vehicle that can model Cars.
 */
public class CarTransport extends Car {
    private CarTrailer carTrailer;

    /**
     * Instantiates a CarTransport
     */
    public CarTransport() {
        super(2, 400, 0, Color.RED, "CarTransport");
        carTrailer = new CarTrailer();
    }

    /**
     * Calculates the speed factor which is engine power with factor 0.8
     * @return returns the speed factor.
     */
    @Override
    public double speedFactor() {
        return getEnginePower() * 0.8;
    }

    /**
     * Add a SmallCar to the carTrailer
     *
     * @param car Car to be loaded
     */
    public void loadCar(SmallCar car) {
        carTrailer.loadCar(car);
    }

    /**
     * Unloads the car and moves it relatively close to the transport
     *
     * @return The unloaded car
     * @throws IllegalAccessException Exception if there are no cars in carTrailer or the ramp is down
     */
    public Car unloadCar() throws IllegalAccessException {
        return carTrailer.unloadCar();
    }

    /**
     * Returns the trailer full of carsK
     * @return the trailer
     */
    public CarTrailer getCarTrailer(){
        return this.carTrailer;
    }

    /**
     * Moves the Car in its current direction by the amount of its current speed.
     * Overrided because we need to update the positions of the cars in the carTrailer
     */
    @Override
    public void move() {
        super.move();
        carTrailer.setCarPos(getCurrentPosition());
    }

    /**
     * need to override to inform the carTrailer of the speed
     * @param speed the speed
     */
    @Override
    public void setCurrentSpeed(double speed) {
        carTrailer.setCurrentSpeed(speed);
        super.setCurrentSpeed(speed);
    }


    /**
     * This method is overrode since we need to check
     * the ramp isn't currently in the down position before moving
     *
     * @param amount Specifies how much the speed should increase by [0,1]
     */
    @Override
    public void gas(double amount) {
        if (carTrailer.getRamp() == CarTrailer.Mode.DOWN)
            super.gas(amount);
    }

}
