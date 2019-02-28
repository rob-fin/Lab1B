import Cars.*;
import CarSupplements.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestServiceStation {
    @Test
    public void testAllCarsAccepted() {
        ServiceStation<Car> ss = new ServiceStation<>();
        Volvo240 v = new Volvo240();
        Saab95 sa = new Saab95();
        CarTransport ct = new CarTransport();
        Scania sc = new Scania();

        ss.load(v);
        ss.load(sa);
        ss.load(ct);
        ss.load(sc);

        assertEquals(ss.getLoad(), 4);
    }

    @Test
    public void testOnlySpecificCarIsAccepted() {
        ServiceStation<Volvo240> ss = new ServiceStation<Volvo240>();
        Volvo240 v = new Volvo240();
        ss.load(v);
        Saab95 s = new Saab95();
        //ss.load(s); // error
        System.out.println(ss.getLoad());
    }

    @Test
    public void testExceptionWhenFull() {
        ServiceStation<Car> ss = new ServiceStation<>();
        Car[] cars = new Car[10];
        for (int i = 0; i < 10; i++) {
            cars[i] = new Volvo240();
            cars[i].enter(ss);
        }
        boolean thrown = false;
        try {
            ss.load(new Saab95());
        } catch (IllegalStateException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    @Test
    public void testExceptionWhenEmpty() {
        ServiceStation<Volvo240> ss = new ServiceStation<Volvo240>();
        boolean thrown = false;
        try {
            ss.unload();
        } catch (IllegalStateException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }
    @Test
    public void testUnload() {
        ServiceStation<Volvo240> ss = new ServiceStation<Volvo240>();
        Volvo240 v = new Volvo240();
        v.enter(ss);
        Volvo240 v2 = ss.unload();
        assertNotNull(v2);
    }


}