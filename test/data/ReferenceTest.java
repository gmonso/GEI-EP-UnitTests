package data;

import exceptions.NullArgumentException;
import exceptions.WrongFormatException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ReferenceTest {

    @Test
    public void correctReference() throws NullArgumentException, WrongFormatException {
        Reference ref = new Reference("12345678901234567890");
        assertEquals("12345678901234567890", ref.getReference());
    }

    @Test
    public void nullReference() {
        Throwable exception = assertThrows(NullArgumentException.class, () -> new Reference(null));
        assertEquals("Reference is null", exception.getMessage());
    }

    @Test
    public void badFormatReference() {
        Throwable exception = assertThrows(WrongFormatException.class, () -> new Reference("12345678901234567890123"));
        assertEquals("Reference is not in the correct format", exception.getMessage());
    }

    @Test
    public void referenceEquals() throws NullArgumentException, WrongFormatException {
        Reference ref = new Reference("12345678901234567890");
        assertTrue(ref.equals(ref));
    }

    @Test
    public void referenceNotEquals() throws NullArgumentException, WrongFormatException {
        Reference ref1 = new Reference("12345678901234567890");
        Reference ref2 = new Reference("12345678901234567891");
        assertFalse(ref1.equals(ref2));
    }

    @Test
    public void referenceEquals2() throws NullArgumentException, WrongFormatException {
        Reference ref1 = new Reference("12345678901234567890");
        Reference ref2 = new Reference("12345678901234567890");
        assertTrue(ref1.equals(ref2));
    }
}
