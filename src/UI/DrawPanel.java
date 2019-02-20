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

import java.util.HashMap;

/* This panel represent the animated part of the view with the car images.

 * This class should only be responsible for drawing out the necessary stuff
 * to the panel
 */
public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    // To keep track of a single cars position


    private HashMap<Car,BufferedImage> carImages = new HashMap<>();

    // Initializes the panel and reads the images
    DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        /*try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Remember to right click src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            //volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("/pics/Volvo240.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }*/

    }
    void addCar(Car car) {
        try {
            if (car instanceof Volvo240) {
                carImages.put(car, ImageIO.read(DrawPanel.class.getResourceAsStream("/pics/Volvo240.jpg")));
            } else if (car instanceof Saab95) {
                carImages.put(car, ImageIO.read(DrawPanel.class.getResourceAsStream("/pics/Saab95.jpg")));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    // TODO: Make this general for all cars
    /*void moveit(int x, int y, Car car){

        volvoPoint.x = x;
        volvoPoint.y = y;
    }*/

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Car car : carImages.keySet())
            g.drawImage(carImages.get(car), car.getCurrentPosition().x, car.getCurrentPosition().y, null); // see javadoc for more info on the parameters
    }
}
