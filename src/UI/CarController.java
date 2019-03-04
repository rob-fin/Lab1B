package UI;

import CarSupplements.CarFactory;
import Cars.*;


import java.util.ArrayList;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 *
 * This class should only be responsible for controlling the cars
 */

class CarController {
    private ArrayList<Car> cars;
    private int gasAmount;
    private int brakeAmount;
    private int xBorder;
    private int yBorder;

    CarController() {
        cars = new ArrayList<>();
        gasAmount = 0;
        brakeAmount = 0;
    }

    void setBorders(int x, int y) {
        xBorder = x;
        yBorder = y;

    }

    void setGasAmount(int gasAmount) {
        this.gasAmount = gasAmount;
    }

    void setBrakeAmount(int brakeAmount) {
        this.brakeAmount = brakeAmount;
    }

    void addCar(Car car) {
            cars.add(car);
    }

    void addCar() {
        if (cars.size() < 10)
            addCar(CarFactory.getInstance().createCar());
    }

    void removeCar() {
        if (!cars.isEmpty()) {
            cars.remove(cars.get(cars.size() - 1));
            CarFactory.getInstance().carRemoved();
        }
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    void start() {
        if (cars.size() > 0)
            for (Car car : cars) {
                if (car.getCurrentSpeed() == 0)
                    car.startEngine();
            }

    }

    void stop() {
        for (Car car : cars)
            car.stopEngine();
    }

    // Calls the gas method for each car once
    void gas() {
        double gas = ((double) gasAmount) / 100;
        for (Car car : cars) {
            car.gas(gas);
        }
    }

    void brake() {
        double brake = ((double) brakeAmount) / 100;
        for (Car car : cars) {
            car.brake(brake);
        }
    }

    void turboOn() {
        for (Car car : cars) {
            if (car instanceof ITurbo) {
                ((ITurbo) car).setTurboOn();
            }
        }
    }

    void turboOff() {
        for (Car car : cars) {
            if (car instanceof ITurbo) {
                ((ITurbo) car).setTurboOff();
            }
        }
    }

    void liftBed() {
        for (Car car : cars) {
            if (car instanceof ITruckBed) {
                ((ITruckBed) car).getWagon().tiltWagon(65);
            }
        }
    }

    void lowerBed() {
        for (Car car : cars) {
            if (car instanceof Scania) {
                ((ITruckBed) car).getWagon().tiltWagon(-65);
            }
        }
    }

    void moveAllCars() {
        for (Car car : cars) {
            car.move();
            checkMove(car);
        }
    }

    //TODO 560 is hardcoded and should be changed
    private void checkMove(Car car) {
        if (car.getCurrentPosition().y > yBorder || car.getCurrentPosition().y < 0 ||
            car.getCurrentPosition().x > xBorder || car.getCurrentPosition().x < 0) {
            car.invertDirection();
        }

    }
}
