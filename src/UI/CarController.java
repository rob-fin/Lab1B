package UI;

import CarSupplements.CarFactory;
import Cars.Car;
import Cars.Saab95;
import Cars.Scania;

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

    CarController() {
        cars = new ArrayList<>();
        gasAmount = 0;
        brakeAmount = 0;
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
        if (cars.size() > 0 && cars.get(0).getCurrentSpeed() == 0)
            for (Car car : cars)
                car.startEngine();

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
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOn();
            }
        }
    }

    void turboOff() {
        for (Car car : cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOff();
            }
        }
    }

    void liftBed() {
        for (Car car : cars) {
            if (car instanceof Scania) {
                ((Scania) car).getWagon().tiltWagon(65);
            }
        }
    }

    void lowerBed() {
        for (Car car : cars) {
            if (car instanceof Scania) {
                ((Scania) car).getWagon().tiltWagon(-65);
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
        if (car.getCurrentPosition().y > 560 - 60 || car.getCurrentPosition().y < 0) {
            car.invertDirection();
        }
    }
}
