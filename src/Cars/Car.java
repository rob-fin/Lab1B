package Cars;

import CarSupplements.Movable;
import CarSupplements.ServiceStation;

import java.awt.*;

/**
 * Models a general Car that more specific Cars can extend.
 */
public abstract class Car implements Movable {
    private final int nrDoors;
    private double currentSpeed;
    private double enginePower;
    private Color color;
    private final String modelName;
    private Point position;
    /**
     * The current direction of the SuperStuff.Car.
     */
    private Direction direction;

    private boolean isLoaded = false;


    /**
     * @param nrDoors      The number of doors
     * @param enginePower  The engine power
     * @param currentSpeed The current speed
     * @param color        The colour
     * @param modelName    The model name
     */
    public Car(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelName;
        this.position = new Point();
        this.direction = Direction.NORTH;
    }

    /**
     * @param position The position to change to
     */
    public void setPosition(Point position) {
        this.position = position;
    }

    /**
     * @return Returns the number of doors
     */
    public int getNrDoors() {
        return nrDoors;
    }

    /**
     * @return Returns the model name
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * @return Returns the engine power
     */
    public double getEnginePower() {
        return enginePower;
    }

    /**
     * @return Returns the color of the car
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param clr Sets the color of the car
     */
    public void setColor(Color clr) {
        color = clr;
    }

    /**
     * Starts the engine
     */
    public void startEngine() {
        currentSpeed = 1;
    }

    /**
     * Stops the engine
     */
    public void stopEngine() {
        setCurrentSpeed(0);
    }

    /**
     * Moves the Car in its current direction by the amount of its current speed.
     */
    public void move() {
        switch (direction) {
            case EAST:
                position.x += currentSpeed;
                break;
            case NORTH:
                position.y -= currentSpeed;
                break;
            case WEST:
                position.x -= currentSpeed;
                break;
            case SOUTH:
                position.y += currentSpeed;
                break;
        }
    }

    /**
     * Changes the direction of the SuperStuff.Car 90 degrees to the left.
     */
    public void turnLeft() {
        switch (direction) {
            case EAST:
                direction = Direction.NORTH;
                break;
            case NORTH:
                direction = Direction.WEST;
                break;
            case WEST:
                direction = Direction.SOUTH;
                break;
            case SOUTH:
                direction = Direction.EAST;
                break;
        }
    }

    /**
     * Changes the direction of the SuperStuff.Car 90 degrees to the right.
     */
    public void turnRight() {
        switch (direction) {
            case EAST:
                direction = Direction.SOUTH;
                break;
            case NORTH:
                direction = Direction.EAST;
                break;
            case WEST:
                direction = Direction.NORTH;
                break;
            case SOUTH:
                direction = Direction.WEST;
                break;
        }
    }

    /**
     * Inverts the direction of the Car
     */
    public void invertDirection() {
        switch (direction) {
            case EAST:
                direction = Direction.WEST;
                break;
            case NORTH:
                direction = Direction.SOUTH;
                break;
            case WEST:
                direction = Direction.EAST;
                break;
            case SOUTH:
                direction = Direction.NORTH;
                break;
        }
    }

    /**
     * Returns the current position of the SuperStuff.Car.
     *
     * @return A reference to a new Point2D.Double representing the current position of the SuperStuff.Car.
     */
    public Point getCurrentPosition() {
        return new Point(position.x, position.y);
    }

    /**
     * @param amount Specifies how much the speed should increase by [0,1]
     */
    public void gas(double amount) {
        if (amount >= 0 && amount <= 1)
            incrementSpeed(amount);
    }

    /**
     * @param amount Specifies how much the speed should decrease [0,1]
     */
    public void brake(double amount) {
        if (amount >= 0 && amount <= 1)
            decrementSpeed(amount);
    }


    /**
     * @return Returns the currentSpeed
     */
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    /**
     * Sets the speed of the Car.
     * @param speed The speed to change to.
     */
    public void setCurrentSpeed(double speed) {
        this.currentSpeed = speed;
    }

    /**
     * @param amount Specifies how much the speed should increase
     */
    private void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }

    /**
     * @param amount specifies how much the speed should decrease
     */
    private void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }

    /**
     * Returns the speed factor of the Car.
     * @return A double with the speed factor of the Car.
     */
    public abstract double speedFactor();

    /**
     * Enters a service station.
     * @param s The service station to enter.
     * @return true for success, false otherwise.
     */
    public boolean enter(ServiceStation s) {
        try {
            s.load(this);
        } catch (IllegalStateException e) {
            return false;
        }
        setLoaded(true);
        return true;
    }

    /**
     * Sets the Car's loaded state
     * @param b true if it is being loaded, false if it's being unloaded.
     */
    public void setLoaded(boolean b) {
        isLoaded = b;
    }

    /**
     * Gets the Car's loaded status.
     * @return true if it is loaded, false if it is not.
     */
    public boolean getLoaded() {
        return isLoaded;
    }

    /**
     * enum type modelling the four cardinal directions.
     */
    public enum Direction {EAST, NORTH, WEST, SOUTH}

    /**
     * Returns the current direction of the car.
     * @return Direction type with the direction.
     */
    public Direction getDirection() {
        return direction;
    }
}

