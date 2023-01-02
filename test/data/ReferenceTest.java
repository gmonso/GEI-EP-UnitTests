package data;

import exceptions.NullArgumentException;
import exceptions.WrongFormatException;
import interfaces.ReferenceTest_Int;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ReferenceTest implements ReferenceTest_Int {

    @Override
    @Test
    public void correctReference() throws NullArgumentException, WrongFormatException {
        Reference ref = new Reference("12345678901234567890");
        assertEquals("12345678901234567890", ref.getReference());
    }

    @Override
    @Test
    public void setterReference() throws NullArgumentException, WrongFormatException {
        Reference ref = new Reference("12345678901234567890");
        ref.setReference("48965478932415234215");
        assertEquals("48965478932415234215", ref.getReference());
        assertNotEquals("12345678901234567890", ref.getReference());
    }

    @Override
    @Test
    public void nullReference() {
        Throwable exception = assertThrows(NullArgumentException.class, () -> new Reference(null));
        assertEquals("Reference is null", exception.getMessage());
    }

    @Override
    @Test
    public void badFormatReference() {
        Throwable exception = assertThrows(WrongFormatException.class, () -> new Reference("12345678901234567890123"));
        assertEquals("Reference is not in the correct format", exception.getMessage());
    }

    @Override
    @Test
    public void referenceEquals() throws NullArgumentException, WrongFormatException {
        Reference ref = new Reference("12345678901234567890");
        assertTrue(ref.equals(ref));
    }

    @Override
    @Test
    public void referenceNotEquals() throws NullArgumentException, WrongFormatException {
        Reference ref1 = new Reference("12345678901234567890");
        Reference ref2 = new Reference("12345678901234567891");
        assertFalse(ref1.equals(ref2));
    }

    @Override
    @Test
    public void referenceEquals2() throws NullArgumentException, WrongFormatException {
        Reference ref1 = new Reference("12345678901234567890");
        Reference ref2 = new Reference("12345678901234567890");
        assertTrue(ref1.equals(ref2));
    }
}
