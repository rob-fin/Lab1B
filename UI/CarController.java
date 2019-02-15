package UI;

import Cars.Car;

import javax.swing.*;
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

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer;

    // The frame that represents this instance View of the MVC pattern
   // private CarView frame;
    // A list of cars, modify if needed
    private ArrayList<Car> cars;
    private int gasAmount;

    CarController(String name) {
        cars = new ArrayList<>();
        timer = new Timer(delay, new TimerListener(cars,new CarView(name, this)));
        gasAmount = 0;

    }

    void setGasAmount(int gasAmount) {
        this.gasAmount = gasAmount;
    }

    void addCar(Car car) {
        cars.add(car);
    }


    void start() {
        timer.start();
    }

    // Calls the gas method for each car once
    void gas() {
        double gas = ((double) gasAmount) / 100;
        for (Car car : cars) {
            car.gas(gas);
        }
    }
}
