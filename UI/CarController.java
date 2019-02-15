package UI;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import Cars.*;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer;

    // The frame that represents this instance View of the MVC pattern
    private CarView frame;
    // A list of cars, modify if needed
    private ArrayList<Car> cars;

    public CarController(String name){
        cars = new ArrayList<>();
        frame = new CarView(name, this);
        timer = new Timer(delay, new TimerListener());

    }


    public void start(){
        timer.start();
    }
    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : cars) {
                car.move();
                int x = car.getCurrentPosition().x;
                int y = car.getCurrentPosition().y;
                frame.drawPanel.moveit(x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars
                ) {
            car.gas(gas);
        }
    }
}
