package UI;

import Cars.Saab95;
import Cars.Scania;
import Cars.Volvo240;


import javax.swing.*;
import java.awt.*;

/*
 * This class should only be responsible for starting up the UI
 */
public class RunUI {



    public static void main(String[] args) {
        CarController cc = new CarController("test");
        cc.addCar(new Volvo240());
        Saab95 saab = new Saab95();
        saab.setPosition(new Point(100, 0));
        cc.addCar(saab);
        Scania scania = new Scania();
        scania.setPosition(new Point(200, 0));
        cc.addCar(scania);

        ICarPainter painter = new DrawPanel(800, 560);
        Timer timer = new Timer(cc, painter);

    }
}
