package UI;

import Cars.Car;

import java.util.ArrayList;

// Observer pattern
public interface ICarPainter {
    void paintCars(ArrayList<Car> cars);
}
