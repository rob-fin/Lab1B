package UI;

import Cars.Volvo240;


import javax.swing.*;

/*
 * This class should only be responsible for starting up the UI
 */
public class RunUI {



    public static void main(String[] args) {
        CarController cc = new CarController("test");
        cc.addCar(new Volvo240());
    }
}
