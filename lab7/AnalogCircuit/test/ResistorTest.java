import coe318.lab7.Resistor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Resistor class.
 */
public class ResistorTest {

    @Test
    public void testGetNode1() {
        Resistor r = new Resistor(1, 2, 10.0);
        assertEquals(1, r.getNode1(), "Node1 should be 1");
    }

    @Test
    public void testGetNode2() {
        Resistor r = new Resistor(1, 2, 10.0);
        assertEquals(2, r.getNode2(), "Node2 should be 2");
    }

    @Test
    public void testGetResistance() {
        Resistor r = new Resistor(1, 2, 10.0);
        assertEquals(10.0, r.getResistance(), 0.0001, "Resistance should be 10.0");
    }
}
