package UI;

import Cars.Volvo240;

/*
 * This class should only be responsible for starting up the UI
 */
public class RunUI {

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController("test");
        cc.addCar(new Volvo240());
        cc.start();

    }
}
