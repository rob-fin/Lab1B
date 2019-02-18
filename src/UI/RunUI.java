package UI;

import Cars.Volvo240;


import javax.swing.*;

/*
 * This class should only be responsible for starting up the UI
 */
public class RunUI {

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private static final int delay = 50;

    public static void main(String[] args) {
        CarController cc = new CarController("test");
        cc.addCar(new Volvo240());

        Timer timer = new Timer(delay, cc);
        timer.start();
    }
}
