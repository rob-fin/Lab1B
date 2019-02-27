package UI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import Cars.Car;
import Cars.Saab95;
import Cars.Volvo240;
import Cars.Scania;


/* This panel represent the animated part of the view with the car images.

 * This class should only be responsible for drawing out the necessary stuff
 * to the panel
 */
public class DrawPanel extends JPanel implements ICarPainter {

    // Initializes the panel and reads the images
    DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
    }

    private Image getImage(Car car) {
        try {
            if (car instanceof Volvo240)
                return ImageIO.read(DrawPanel.class.getResourceAsStream("/pics/Volvo240.jpg"));
            else if (car instanceof Saab95)
                return ImageIO.read(DrawPanel.class.getResourceAsStream("/pics/Saab95.jpg"));
            else if (car instanceof Scania)
                return ImageIO.read(DrawPanel.class.getResourceAsStream("/pics/Scania.jpg"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void paintCars(ArrayList<Car> cars) {
        this.repaint();
        for (Car car : cars)
            this.getGraphics().drawImage(getImage(car), car.getCurrentPosition().x, car.getCurrentPosition().y, null); // see javadoc for more info on the parameters
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
