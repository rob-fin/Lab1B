import Cars.*;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.awt.geom.Point2D;

import static org.junit.Assert.*;

public class CarTests {
    private Volvo240 volvo;
    private Saab95 saab;
    private Scania scania;
    private CarTransport carTransport;

    @Before
    public void init() {
        volvo = new Volvo240();
        saab = new Saab95();
        scania = new Scania();
        carTransport = new CarTransport();
    }

    @Test
    public void testDoors() {
        assertEquals(volvo.getNrDoors(), 4);
    }

    @Test
    public void testModelName() {
        assertSame(saab.getModelName(), "Saab95");
    }

    @Test
    public void carColorTest() {
        volvo.setColor(Color.LIGHT_GRAY);
        saab.setColor(Color.LIGHT_GRAY);
        assertSame(volvo.getColor(), Color.LIGHT_GRAY);
        assertSame(saab.getColor(), Color.LIGHT_GRAY);
    }

    @Test
    public void testGas() {
        volvo.gas(0.9);
        saab.gas(0.87);
        assertTrue(volvo.getCurrentSpeed() >= 0 && volvo.getCurrentSpeed() <= volvo.getEnginePower());
        assertTrue(saab.getCurrentSpeed() >= 0 && saab.getCurrentSpeed() <= saab.getEnginePower());
    }

    @Test
    public void testBrake() {
        volvo.brake(0.36);
        saab.brake(0.47);
        assertTrue(volvo.getCurrentSpeed() >= 0 && volvo.getCurrentSpeed() <= volvo.getEnginePower());
        assertTrue(saab.getCurrentSpeed() >= 0 && saab.getCurrentSpeed() <= saab.getEnginePower());
    }

    @Test
    public void testMoveNorth() {
        volvo.setCurrentSpeed(5);
        volvo.move();
        assertSame(volvo.getDirection(), Car.Direction.NORTH);
    }

    @Test
    public void testTurnRight() {
        saab.setCurrentSpeed(12);
        saab.turnRight();
        assertSame(saab.getDirection(), Car.Direction.EAST);
    }

    @Test
    public void testTurnLeft() {
        scania.setCurrentSpeed(4);
        scania.turnLeft();
        assertSame(scania.getDirection(), Car.Direction.WEST);
    }

    @Test
    public void testSouth() {
        carTransport.setCurrentSpeed(2.7);
        carTransport.turnLeft();
        carTransport.turnLeft();
        assertSame(carTransport.getDirection(), Car.Direction.SOUTH);
    }

    @Test
    public void testPosition() {
        Point2D.Double pos = new Point2D.Double();
        pos.x = 5.0;
        pos.y = 7.0;
        volvo.setPosition(pos);
        assertEquals(volvo.getCurrentPosition(), pos);
    }

    @Test
    public void testSpeedDecreaseIfNotTurbo() {
        Saab95 s = new Saab95();
        s.setTurboOn();
        s.startEngine();
        s.gas(1);
        double turboSpeed = s.getCurrentSpeed();
        s.stopEngine();
        s.setTurboOff();
        s.startEngine();
        s.gas(1);
        double noTurboSpeed = s.getCurrentSpeed();
        assertTrue(turboSpeed > noTurboSpeed);
    }

    @Test
    public void testSpeedIncreaseIfTurbo() {
        Saab95 s1 = new Saab95();
        Saab95 s2 = new Saab95();
        s1.setTurboOn();
        s1.startEngine();
        s2.startEngine();
        s1.gas(1);
        s2.gas(1);
        assertTrue(s1.getCurrentSpeed() > s2.getCurrentSpeed());
    }
}
