package UI;

import Cars.Car;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
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
        this.frame = new CarView(this,name);
        drawWidth = frame.getDrawWidth();
        drawHeigth = frame.getDrawHeigth();
        timer = new Timer(delay, this);

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

    public void start() {
        timer.start();
    }

    public void stop() {
        timer.stop();
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
    public void actionPerformed(ActionEvent e) {
        for (Car car : cars) {
            car.move();

            if (car.getCurrentPosition().y > 20)
                car.setCurrentSpeed(-car.getCurrentSpeed());

            int x = car.getCurrentPosition().x;
            int y = car.getCurrentPosition().y;
            frame.drawPanel.moveit(x, y);
            // repaint() calls the paintComponent method of the panel
            frame.drawPanel.repaint();
        }
    }
}
