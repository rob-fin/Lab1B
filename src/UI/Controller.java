package UI;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener, ChangeListener {
    private CarController carC;

    void setCarController(CarController carC) {
        this.carC = carC;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String command = actionEvent.getActionCommand();
        switch (command) {
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
            default:
                System.out.println("DEBUG : '" + command + "' was ignored");
                break;
        }
    }

    public void stateChanged(ChangeEvent e) {
        int value = (int) ((JSpinner) e.getSource()).getValue();
        carC.setBrakeAmount(value);
        carC.setGasAmount(value);
    }
}
