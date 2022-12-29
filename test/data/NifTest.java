package data;

import exceptions.NullArgumentException;
import exceptions.WrongFormatException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NifTest {

    @Test
    public void correctNif() throws NullArgumentException, WrongFormatException {
        Nif nif = new Nif("12345678A");
        assertEquals("12345678A", nif.getNif());
    }

    @Test
    public void nullNif() {
        Throwable exception = assertThrows(NullArgumentException.class, () -> new Nif(null));
        assertEquals("Nif is null", exception.getMessage());
    }

    @Test
    public void badFormatNif() {
        Throwable exception = assertThrows(WrongFormatException.class, () -> new Nif("123456L"));
        assertEquals("Nif is not in the correct format", exception.getMessage());
    }

    @Test
    public void nifEquals() throws NullArgumentException, WrongFormatException {
        Nif nif = new Nif("12345678A");
        assertTrue(nif.equals(nif));
    }

    @Test
    public void nifNotEquals() throws NullArgumentException, WrongFormatException {
        Nif nif1 = new Nif("12345678A");
        Nif nif2 = new Nif("12345678B");
        assertFalse(nif1.equals(nif2));
    }

    @Test
    public void nifEquals2() throws NullArgumentException, WrongFormatException {
        Nif nif1 = new Nif("12345678A");
        Nif nif2 = new Nif("12345678A");
        assertTrue(nif1.equals(nif2));
    }
}
