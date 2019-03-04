package UI;

import CarSupplements.CarFactory;

/*
 * This class should only be responsible for starting up the UI
 */
public class RunUI {


    public static void main(String[] args) {
        final int imageDimensionX = 100;
        final int imageDimensionY = 60;
        final int controlPanelHeight = 240;

        CarController cc = new CarController();
        cc.addCar(CarFactory.getInstance().createCar(CarFactory.carType.Volvo));
        cc.addCar(CarFactory.getInstance().createCar(CarFactory.carType.Saab));
        cc.addCar(CarFactory.getInstance().createCar(CarFactory.carType.Scania));

        Controller ctrl = new Controller();
        DrawPanel painter = new DrawPanel(CarView.X, CarView.Y - controlPanelHeight, imageDimensionX, imageDimensionY);
        ctrl.setCarController(cc);

        CarView cw = new CarView("test", ctrl, painter);
        cc.setBorders(CarView.X, CarView.Y - controlPanelHeight - imageDimensionY);
        Timer timer = new Timer(cc, painter);

    }
}
