package UI;

import Cars.Car;
import Cars.Saab95;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 *
 * This class should only be responsible for controlling the cars
 */

class CarController implements ActionListener {
    // member fields:
// The delay (ms) corresponds to 20 updates a sec (hz)
    private static final int delay = 50;

    // A list of cars, modify if needed
    private ArrayList<Car> cars;
    private int gasAmount;
    private int brakeAmount;
    private CarView frame;
    private Timer timer;
    private int drawWidth;
    private int drawHeigth;


    CarController(String name) {
        cars = new ArrayList<>();
        gasAmount = 0;
        brakeAmount = 0;
        this.frame = new CarView(this, name);
        drawWidth = frame.getDrawWidth();
        drawHeigth = frame.getDrawHeigth();
        timer = new Timer(delay, this);
        timer.start();

    }

    void setGasAmount(int gasAmount) {
        this.gasAmount = gasAmount;
    }

    void setBrakeAmount(int brakeAmount) {
        this.brakeAmount = brakeAmount;
    }

    void addCar(Car car) {
        cars.add(car);
        frame.drawPanel.addCar(car);
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void start() {
        for (Car car : cars)
            car.startEngine();
    }

    public void stop() {
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

    public void actionPerformed(ActionEvent e) {
        for (Car car : cars) {
            car.move();

            checkMove(car);

            //frame.drawPanel.moveit(x, y, car);
            // repaint() calls the paintComponent method of the panel

        }
        frame.drawPanel.repaint();
    }

    private void checkMove(Car car) {
        if (car.getCurrentPosition().y > drawHeigth - 60 || car.getCurrentPosition().y < 0) {
            car.invertDirection();
        }
    }
}
