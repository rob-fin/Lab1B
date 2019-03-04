package CarSupplements;

import Cars.*;

import java.awt.*;
import java.util.Stack;

/**
 * Models a car trailer used by Car Transports.
 */
public class CarTrailer {
    /**
     * Enum modelling the two positions of the ramp of the trailer.
     */
    public enum Mode {
        UP, DOWN
    }

    private static final int MAX_CAR = 10;
    private Stack<SmallCar> cars;
    private Mode ramp;
    private double currentSpeed;

    /**
     * Instantiates a new CarTrailer
     */
    public CarTrailer() {
        ramp = Mode.DOWN;
        cars = new Stack<>();
        currentSpeed = 0;
    }

    /**
     * Add a SmallCar to the cargo
     *
     * @param car Car to be loaded
     */
    public void loadCar(SmallCar car) {
        if (cars.size() <= MAX_CAR && ramp == Mode.DOWN)
            cars.push(car);
    }

    /**
     * Unloads the car and moves it relatively close to the transport
     *
     * @return The unloaded car
     * @throws IllegalAccessException Exception if there are no cars in cargo or the ramp is down
     */
    public Car unloadCar() throws IllegalAccessException {
        if (ramp != Mode.DOWN || cars.size() <= 0)
            throw new IllegalAccessException("The ramp is not lowered or there are no cars in the cargo!");

        Car car = cars.pop();
        // Move car relatively close to the CarTransport
        Point pos = car.getCurrentPosition();
        pos.x -= 1;
        pos.y -= 1;
        car.setPosition(pos);
        return car;
    }

    /**
     * @return Returns the amount of cars in the cargo
     */
    public int getLoad() {
        return cars.size();
    }

    /**
     * Moves all the cars to a position
     *
     * @param p position to be changed to
     */
    public void setCarPos(Point p) {
        for (Car c : cars)
            c.setPosition(p);

    }

    /**
     * Returns the position of the ramp
     *
     * @return the ramp's position
     */
    public Mode getRamp() {
        return ramp;
    }

    /**
     * @param ramp Mode to be changed to
     */
    public void setRamp(Mode ramp) {
        if (currentSpeed == 0)
            this.ramp = ramp;
    }

    /**
     * Returns the current speed of the CarTrailer
     *
     * @return A double with the current speed
     */
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    /**
     * Sets the current speed of the car trailer
     *
     * @param currentSpeed A double with the speed to set to.
     */
    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }
}
