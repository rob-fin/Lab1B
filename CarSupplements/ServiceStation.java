package CarSupplements;

import Cars.*;

import java.util.LinkedList;

public class ServiceStation<T extends Car>  {

    private LinkedList<T> cars;
    private static final int MAX_CARS = 10;

    public ServiceStation() {
        cars = new LinkedList<>();
    }


    public void load(T car) {
        if (cars.size() >= MAX_CARS) {
            throw new IllegalStateException("Service station at full capacity");
        }
        cars.add(car);
    }

    public T unload() {
        if (cars.size() == 0) {
            throw new IllegalStateException("No cars to unload");
        }
        return cars.remove();
    }


    public int getLoad() {
        return cars.size();
    }

}
