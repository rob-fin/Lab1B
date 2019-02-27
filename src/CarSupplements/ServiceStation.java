package CarSupplements;

import Cars.*;

import java.util.LinkedList;

/**
 * Models a service station that can service different Cars or some specific car,
 * depending on how the class is instantiated
 * @param <T> The type of the Car: Either Car or a subclass thereof.
 */
public class ServiceStation<T extends Car>  {

    private LinkedList<T> cars;
    private static final int MAX_CARS = 10;

    public ServiceStation() {
        cars = new LinkedList<>();
    }

    /**
     * Loads cars into the station
     * @param car car to be loaded
     */
    public void load(T car) {
        if (cars.size() >= MAX_CARS) {
            throw new IllegalStateException("Service station at full capacity");
        }
        cars.add(car);
    }

    /**
     * Unloads a car and return it
     * @return the unloaded car
     */
    public T unload() {
        if (cars.size() == 0) {
            throw new IllegalStateException("No cars to unload");
        }
        return cars.remove();
    }

    /**
     * Returns the amount of cars
     * @return amount of cars
     */
    public int getLoad() {
        return cars.size();
    }

}
