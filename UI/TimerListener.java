package UI;

import Cars.Car;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TimerListener implements ActionListener{
    private CarView frame;
    private ArrayList<Car> cars;

    public TimerListener(ArrayList<Car> cars, CarView frame){
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