import CarSupplements.CarTrailer;
import Cars.Car;
import Cars.CarTransport;
import Cars.Scania;
import Cars.Volvo240;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TruckTest {

    private CarTransport carTransport;
    private Scania scania;
    private Volvo240 volvo;

    @Before
    public void init() {
        carTransport = new CarTransport();
        scania = new Scania();
        volvo = new Volvo240();
    }

    @Test
    public void testLoad() {
        boolean thrown = false;
        volvo.enter(carTransport);
        Car car1 = new Scania();

        try {
            car1 = carTransport.unloadCar();
        } catch (IllegalAccessException e) {
            thrown = true;
        }
        assertTrue(car1.getModelName().equals("Volvo240") && !thrown);
    }

    @Test
    public void loadTwice() {
        volvo.enter(carTransport);
        volvo.enter(carTransport); // ?? you can't load the same car twice
        assertEquals(carTransport.getCarTrailer().getLoad(), 1);
    }

    @Test
    public void loadException() {
        boolean thrown = false;
        try {
            Car car1 = carTransport.getCarTrailer().unloadCar();
        } catch (IllegalAccessException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }
    @Test
    public void ramp(){
        carTransport.setCurrentSpeed(2);
        carTransport.getCarTrailer().setRamp(CarTrailer.Mode.UP);
        assertSame(carTransport.getCarTrailer().getRamp(), CarTrailer.Mode.DOWN);

    }
    @Test
    public void rampUp(){
        carTransport.getCarTrailer().setRamp(CarTrailer.Mode.UP);
        carTransport.getCarTrailer().loadCar(volvo);
        assertSame(carTransport.getCarTrailer().getLoad(), 0);
    }
    @Test
    public void move(){
        carTransport.setCurrentSpeed(0.2);
        carTransport.move();
        assertTrue(carTransport.getCurrentSpeed() == 0.2 && carTransport.getCarTrailer().getCurrentSpeed() == 0.2);
    }

    @Test
    public void testMoveCarTransport() {
        carTransport.setCurrentSpeed(3.2);
        carTransport.move();
        assertSame(carTransport.getDirection(), Car.Direction.NORTH);
    }

    @Test
    public void testCarTransportGas() {
        carTransport.gas(0.67);
        assertTrue(carTransport.getCurrentSpeed() >= 0 && carTransport.getCurrentSpeed() <= carTransport.getEnginePower());
    }

    @Test
    public void testCarTransportGasRampDown() {
        carTransport.getCarTrailer().setRamp(CarTrailer.Mode.DOWN);
        carTransport.gas(0.67);
        assertTrue(carTransport.getCurrentSpeed() >= 0 && carTransport.getCurrentSpeed() <= carTransport.getEnginePower());
    }
    @Test
    public void moveWithRamp(){
        carTransport.getCarTrailer().setRamp(CarTrailer.Mode.UP);
        carTransport.gas(0.3);
        assertEquals(0, carTransport.getCurrentSpeed(), 0.0);
    }

    @Test
    public void testScaniaSpeedFactor() {
        assertEquals(scania.speedFactor(), scania.getEnginePower() * 0.003, 0.0);
    }
}
