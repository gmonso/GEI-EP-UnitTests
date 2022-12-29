package data;

import exceptions.NullArgumentException;
import exceptions.WrongFormatException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
}
