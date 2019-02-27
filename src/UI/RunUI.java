package UI;

import Cars.Saab95;
import Cars.Scania;
import Cars.Volvo240;

import java.awt.*;

/*
 * This class should only be responsible for starting up the UI
 */
public class RunUI {



    public static void main(String[] args) {
        //region Create carController and add cars
        CarController cc = new CarController();
        cc.addCar(new Volvo240());
        Saab95 saab = new Saab95();
        saab.setPosition(new Point(100, 0));
        cc.addCar(saab);
        Scania scania = new Scania();
        scania.setPosition(new Point(200, 0));
        cc.addCar(scania);
        //endregion

        Controller ctrl = new Controller();

        DrawPanel painter = new DrawPanel(CarView.X, CarView.Y - 240);
        ctrl.setCarController(cc);

        CarView cw = new CarView("test", ctrl, painter);

        Timer timer = new Timer(cc, painter);

    }
}
