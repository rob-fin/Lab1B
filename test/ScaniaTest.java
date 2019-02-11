import Cars.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ScaniaTest {

    private Scania scania;
    private CarTransport carTransport;
    private Volvo240 volvo;

    @Before
    public void init() {
        scania = new Scania();
        carTransport = new CarTransport();
        volvo = new Volvo240();
    }

    @Test
    public void Tilt() {
        scania.setCurrentSpeed(2);
        scania.getWagon().tiltWagon(20);
        assertEquals(scania.getWagon().getWagonAngle(), 0.0, 0);
    }

    @Test
    public void Tilt1() {
        scania.getWagon().tiltWagon(25);
        scania.getWagon().tiltWagon(-24.5);
        assertEquals(scania.getWagon().getWagonAngle(), 0.5, 0);
    }

    @Test
    public void wrongAngle() {
        scania.getWagon().tiltWagon(-0.00003);
        assertEquals(scania.getWagon().getWagonAngle(), 0.0, 0);
    }


}
