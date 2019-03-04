package CarSupplements;

import Cars.*;

import java.awt.*;
import java.util.Random;

public class CarFactory {
    private static final CarFactory instance = new CarFactory();
    private int currentX;
    private Random rand = new Random();

    private CarFactory() {
        currentX = 0;
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
        car.setPosition(new Point(currentX, 0));
        car.stopEngine();
        currentX += 100;
        return car;
    }

    public Car createCar() {
        int randomNumber = rand.nextInt(carType.values().length);
        carType newCarType = carType.values()[randomNumber];
        return createCar(newCarType);


    }

    public enum carType {Volvo, Saab, Scania, CarTransport}
}
