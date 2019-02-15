package UI;

import Cars.Car;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * This class should only be responsible for handling the actionPerformed
 * This class could be moved into CarController but it might be easier to implement
 * new features with the class being alone
 */
public class TimerListener implements ActionListener{
    // This is only a reference to the CarView in RunUI
    private CarView frame;
    // This is only a reference to the  cars in carController
    private ArrayList<Car> cars;

    TimerListener(ArrayList<Car> cars, CarView frame) {
        this.cars = cars;
        this.frame =  frame;
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
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