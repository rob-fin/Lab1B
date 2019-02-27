package UI;

import Cars.Car;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Timer class to keep track of when the cars need to be updated and
 * then notify all its observers
 */
public class Timer implements ActionListener {
    private static final int delay = 50;
    private final javax.swing.Timer timer;
    private CarController carC;
    private List<ICarPainter> observers;

    Timer(CarController carC){
        this.carC = carC;
        timer = new javax.swing.Timer(delay, this);
        observers = new ArrayList<>();
        timer.start();
    }
    Timer(CarController carC, ICarPainter observer){
        this(carC);
        observers.add(observer);
    }

    /**
     * Add an observer to be notified when the cars need repainting
     * @param observer the observer to be added
     */
    void addObserber(ICarPainter observer){
        observers.add(observer);
    }

    /**
     * Remove an observer to be notified when the cars need repainting
     * @param observer the observer to be removed
     */
    void removeObserber(ICarPainter observer){
        observers.remove(observer);
    }

    // This is called every timer 'tick'
    @Override
    public void actionPerformed(ActionEvent e) {
        carC.moveAllCars();
        ArrayList<Car> cars = carC.getCars();
        // Notify all observers that something has happened and we need to repaint all the cars
        for (ICarPainter observer : observers)
            observer.paintCars(cars);
    }
}
