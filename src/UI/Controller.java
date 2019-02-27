package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    CarController carC;

    public void setCarController(CarController carC) {
        this.carC = carC;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String command = actionEvent.getActionCommand();
        switch(command) {
            case "Gas":
                carC.gas();
                break;
            case "Brake":
                carC.brake();
                break;
            case "Saab Turbo On":
                carC.turboOn();
                break;
            case "Saab Turbo Off":
                carC.turboOff();
                break;
            case "Scania Lift Bed":
                carC.liftBed();
                break;
            case "Lower Lift Bed":
                carC.lowerBed();
                break;
            case "Start all cars":
                carC.start();
                break;
            case "Stop all cars":
                carC.stop();
                break;
        }

    }
    public void setGasBrakeAmount(int amount) {
        carC.setGasAmount(amount);
        carC.setBrakeAmount(amount);
    }
}
