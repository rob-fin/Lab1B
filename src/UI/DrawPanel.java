package UI;

import Cars.Car;
import Cars.Saab95;
import Cars.Scania;
import Cars.Volvo240;
import Cars.CarTransport;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

/* This panel represent the animated part of the view with the car images.

 * This class should only be responsible for drawing out the necessary stuff
 * to the panel
 */
public class DrawPanel extends JPanel implements ICarPainter {
    private ArrayList<Car> cars = new ArrayList<>();

    // Initializes the panel and reads the images
    DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
    }

    private Image getImage(Car car) {
        try {
            String filePath = "/pics/" + car.getModelName() + ".jpg";
            return ImageIO.read(DrawPanel.class.getResourceAsStream(filePath));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private void paintCars(Graphics g) {
        for (Car car : cars)
            g.drawImage(getImage(car), car.getCurrentPosition().x, car.getCurrentPosition().y, null);
    }

    public void paintCars(ArrayList<Car> cars) {
        this.cars = cars;
        this.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (cars != null)
            paintCars(g);
    }
}

