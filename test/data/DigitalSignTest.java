package data;

import exceptions.NullArgumentException;
import exceptions.WrongFormatException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DigitalSignTest {

    @Test
    public void nullDigitalSign() {
        Throwable exception = assertThrows(NullArgumentException.class, () -> new DigitalSignature(null));
        assertEquals("DigitalSignature is null", exception.getMessage());
    }

    @Test
    public void badFormatDigitalSign() {
        Throwable exception = assertThrows(WrongFormatException.class, () -> new DigitalSignature(new byte[]{1,2})
        );
        assertEquals("DigitalSignature is not in the correct format", exception.getMessage());
    }

    @Test
    public void correctFormat() throws NullArgumentException, WrongFormatException {
        byte[] signature = new byte[]{1,2,3,4,5,6,7,8,9,4,3,6};
        DigitalSignature digitalSignature = new DigitalSignature(signature);
        assertEquals(signature, digitalSignature.getSignature());
    }
}
