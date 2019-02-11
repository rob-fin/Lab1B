package CarSupplements;

import Cars.*;
import java.awt.geom.Point2D;
import java.util.Stack;

public class CarTrailer {
    public enum Mode {
        UP, DOWN
    }

    private static final int MAX_CAR = 10;
    private Stack<SmallCar> cars;
    private Mode ramp;
    double currentSpeed = 0;
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
        Point2D.Double pos = car.getCurrentPosition();
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
    public void setCarPos(Point2D.Double p) {
        for (Car c : cars)
            c.setPosition(p);

    }

    /**
     * @return the ramp
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

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }
}
