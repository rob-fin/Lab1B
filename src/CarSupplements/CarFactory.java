package CarSupplements;

import java.awt.*;
import java.util.Random;
import Cars.*;

public class CarFactory {
    private static final CarFactory instance = new CarFactory();
    Random rand = new Random();
    private static int lastXPos = 0;

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
        car.setPosition(new Point(lastXPos, 0));
        lastXPos += 100;
        return car;
    }

    public Car createCar() {
        int randomNumber = rand.nextInt(carType.values().length);
        carType newCarType = carType.values()[randomNumber];
        return createCar(newCarType);


    }

    public enum carType {Volvo, Saab, Scania, CarTransport}
}
