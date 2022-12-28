package data;

import exceptions.NullArgumentException;
import exceptions.WrongFormatException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class DigitalSignTest {

    DigitalSignature ds;

    @BeforeEach
    public void init() throws NullArgumentException, WrongFormatException {
        ds = new DigitalSignature(new byte[10]);
    }

    @Test
    public void ConstructorTest() {
        System.out.println(ds.getSignature());
        assertEquals(10, ds.getSignature().length);
    }

    @Test
    public void nullDigitalSign() {
        try {
            new DigitalSignature(null);
        } catch (NullArgumentException ignored) {
            System.out.println(ignored.getMessage());
        } catch (WrongFormatException ignored) {
            System.out.println(ignored.getMessage());
        }
    }

    @Test
    public void badFormatDigitalSign() {
        try {
            new DigitalSignature(new byte[0]);
        } catch (WrongFormatException ignored) {
            System.out.println(ignored.getMessage());
        } catch (NullArgumentException ignored) {
            fail();
        }
    }
}
