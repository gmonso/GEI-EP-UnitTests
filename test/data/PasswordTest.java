package data;

import exceptions.NullArgumentException;
import exceptions.WrongFormatException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PasswordTest {

    @Test
    public void NullPassword() {
        Throwable exception = assertThrows(NullArgumentException.class, () -> new Password(null));
        assertEquals("Password is null", exception.getMessage());
    }

    @Test
    public void badFormat() {
        Throwable exception = assertThrows(WrongFormatException.class, () -> new Password("123458"));
        assertEquals("Password is not in the correct format", exception.getMessage());
    }

    @Test
    public void correctFormat() throws NullArgumentException, WrongFormatException {
        Password password = new Password("Hell0W0rld");
        assertEquals("Hell0W0rld", password.getPassword());
    }
}
