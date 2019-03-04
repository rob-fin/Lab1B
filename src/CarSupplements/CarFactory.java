package CarSupplements;

import Cars.*;

public class CarFactory {
    private static final CarFactory instance = new CarFactory();

    private CarFactory() {
    }

    public static CarFactory getInstance() {
        return instance;
    }

    public Car createCar(carType t) {
        Car car = new Volvo240(); // Needs to be initialized
        switch (t) {
            case Volvo:
                car = new Volvo240();
                break;
            case Saab:
                car = new Saab95();
                break;
            case Scania:
                car = new Scania();
                break;
            case CarTransport:
                car = new CarTransport();
                break;
        }
        car.stopEngine();
        return car;
    }

    public enum carType {Volvo, Saab, Scania, CarTransport}
}
