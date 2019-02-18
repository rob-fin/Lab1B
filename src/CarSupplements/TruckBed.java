package CarSupplements;

/**
 * Models a truck bed that can be used by Scanias.
 */
public class TruckBed {
    private double wagonAngle;
    private double truckSpeed;

    /**
     * Instantiates a TruckBed.
     */
    public TruckBed() {
        this.wagonAngle = 0;
        this.truckSpeed = 0;
    }

    /**
     * Checks that the angle is between 0 and 70 if the truck isn't moving
     * and that the angle is 0 if the truck is moving
     *
     * @param angle angle so check
     * @return returns if the angle is correct
     */
    private boolean checkAngle(double angle) {
        return truckSpeed == 0 && angle >= 0 && angle <= 70 || angle == 0;
    }

    /**
     * Tilts the wagon either up or down depending on the angle value it's given
     *
     * @param angle amount of degrees to tilt up or down
     */
    public void tiltWagon(double angle) {
        double newAngle = this.wagonAngle + angle;
        if (checkAngle(newAngle))
            this.wagonAngle = newAngle;
    }

    /**
     * Sets the truck speed
     *
     * @param truckSpeed speed
     */
    public void setTruckSpeed(double truckSpeed) {
        this.truckSpeed = truckSpeed;
    }

    /**
     * @return wagon angle
     */
    public double getWagonAngle() {
        return wagonAngle;
    }

}
