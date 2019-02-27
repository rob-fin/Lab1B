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
    private ArrayList<Car> cars;
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

    public void paintCars(Graphics g) {
        if (g == null){
            System.out.println("g is null");
        }
        if (cars == null){
            System.out.println("cars is null in second paintCars");
        }

        for (Car car : cars)
            g.drawImage(getImage(car), car.getCurrentPosition().x, car.getCurrentPosition().y, null);
    }

    public void paintCars(ArrayList<Car> cars){
        if (cars == null){
            System.out.println("Cars is null in the first paintCars");
        }
        this.cars = cars;
        this.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (cars == null){
            System.out.println("cars is null in paintComponent");
        }
        paintCars(g);


    }}

