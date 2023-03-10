package data;

import exceptions.NullArgumentException;
import exceptions.WrongFormatException;
import interfaces.DigitalSignTest_Int;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DigitalSignTest implements DigitalSignTest_Int {

    @Override
    @Test
    public void nullDigitalSign() {
        Throwable exception = assertThrows(NullArgumentException.class, () -> new DigitalSignature(null));
        assertEquals("DigitalSignature is null", exception.getMessage());
    }

    @Override
    @Test
    public void badFormatDigitalSign() {
        Throwable exception = assertThrows(WrongFormatException.class, () -> new DigitalSignature(new byte[]{1, 2})
        );
        assertEquals("DigitalSignature is not in the correct format", exception.getMessage());
    }

    @Override
    @Test
    public void correctDigitalSign() throws NullArgumentException, WrongFormatException {
        byte[] signature = new byte[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 4, 3, 6};
        DigitalSignature digitalSignature = new DigitalSignature(signature);
        assertEquals(signature, digitalSignature.getSignature());
    }

    @Override
    @Test
    public void digitalSignEquals() throws NullArgumentException, WrongFormatException {
        byte[] signature = new byte[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 4, 3, 6};
        DigitalSignature digitalSignature = new DigitalSignature(signature);
        assertTrue(digitalSignature.equals(digitalSignature));
    }

    @Override
    @Test
    public void digitalSignNotEquals() throws NullArgumentException, WrongFormatException {
        DigitalSignature digitalSignature1 = new DigitalSignature(new byte[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 4, 3, 6});
        DigitalSignature digitalSignature2 = new DigitalSignature(new byte[]{1, 2, 3, 4, 5, 6, 7});
        assertFalse(digitalSignature1.equals(digitalSignature2));
    }

    @Override
    @Test
    public void digitalSignEquals2() throws NullArgumentException, WrongFormatException {
        DigitalSignature digitalSignature1 = new DigitalSignature(new byte[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 4, 3, 6});
        DigitalSignature digitalSignature2 = new DigitalSignature(new byte[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 4, 3, 6});
        assertTrue(digitalSignature1.equals(digitalSignature2));
    }
}
