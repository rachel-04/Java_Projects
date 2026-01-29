/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package lab1;

import org.junit.Test;
import static org.junit.Assert.*;

public class FlightTest {

    @Test
    public void testConstructor() {
        Flight f = new Flight(1030, "Toronto", "Kolkata", "03/02/99 7:50 pm", 10, 1000.0);

        assertEquals(1030, f.getFlightNumber());
        assertEquals("Toronto", f.getOrigin());
        assertEquals("Kolkata", f.getDestination());
        assertEquals("03/02/99 7:50 pm", f.getDepartureTime());
        assertEquals(10, f.getCapacity());
        assertEquals(10, f.getNumberOfSeatsLeft()); // starts at capacity
        assertEquals(1000.0, f.getOriginalPrice(), 0.0001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidConstructor() {
        new Flight(100, "Toronto", "Toronto", "1:00", 5, 100.0);
    }

    @Test
    public void testGettersSetters() {
        Flight f = new Flight(1, "A", "B", "10:00", 2, 50.0);

        f.setFlightNumber(99);
        assertEquals(99, f.getFlightNumber());

        f.setOrigin("X");
        assertEquals("X", f.getOrigin());

        f.setDestination("Y");
        assertEquals("Y", f.getDestination());

        f.setDepartureTime("11:00");
        assertEquals("11:00", f.getDepartureTime());

        f.setCapacity(7);
        assertEquals(7, f.getCapacity());

        f.setNumberOfSeatsLeft(4);
        assertEquals(4, f.getNumberOfSeatsLeft());

        f.setOriginalPrice(999.99);
        assertEquals(999.99, f.getOriginalPrice(), 0.0001);
    }

    @Test
    public void testBookASeat() {
        Flight f = new Flight(10, "Toronto", "Vancouver", "2:00PM", 2, 200.0);

        assertTrue(f.bookASeat());
        assertEquals(1, f.getNumberOfSeatsLeft());

        assertTrue(f.bookASeat());
        assertEquals(0, f.getNumberOfSeatsLeft());

      
        assertFalse(f.bookASeat());
        assertEquals(0, f.getNumberOfSeatsLeft());
    }

    @Test
    public void testToStringContainsRequiredInfo() {
        Flight f = new Flight(1030, "Toronto", "Kolkata", "03/02/99 7:50 pm", 10, 1000.0);

        String s = f.toString();

        
        assertTrue(s.contains("1030"));
        assertTrue(s.contains("Toronto"));
        assertTrue(s.contains("Kolkata"));
        assertTrue(s.contains("03/02/99 7:50 pm"));
        assertTrue(s.contains("1000"));
    }
}
