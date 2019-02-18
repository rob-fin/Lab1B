package UI;

import Cars.Car;

import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 *
 * This class should only be responsible for controlling the cars
 */

class CarController {
    // member fields:


    // A list of cars, modify if needed
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

    public ArrayList<Car> getCars() {
        return cars;
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
}
