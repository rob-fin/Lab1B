package UI;

import CarSupplements.CarFactory;

/*
 * This class should only be responsible for starting up the UI
 */
public class RunUI {



    public static void main(String[] args) {
        CarController cc = new CarController();
        cc.addCar(CarFactory.getInstance().createCar(CarFactory.carType.Volvo));
        cc.addCar(CarFactory.getInstance().createCar(CarFactory.carType.Saab));
        cc.addCar(CarFactory.getInstance().createCar(CarFactory.carType.Scania));

        Controller ctrl = new Controller();
        DrawPanel painter = new DrawPanel(CarView.X, CarView.Y - 240);
        ctrl.setCarController(cc);

        CarView cw = new CarView("test", ctrl, painter);
        Timer timer = new Timer(cc, painter);

    }
}
