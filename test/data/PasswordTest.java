package data;

import exceptions.NullArgumentException;
import exceptions.WrongFormatException;
import interfaces.PasswordTest_Int;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordTest implements PasswordTest_Int {

    @Override
    @Test
    public void nullPassword() {
        Throwable exception = assertThrows(NullArgumentException.class, () -> new Password(null));
        assertEquals("Password is null", exception.getMessage());
    }

    @Override
    @Test
    public void badFormat() {
        Throwable exception = assertThrows(WrongFormatException.class, () -> new Password("123458"));
        assertEquals("Password is not in the correct format", exception.getMessage());
    }

    @Override
    @Test
    public void correctFormat() throws NullArgumentException, WrongFormatException {
        Password password = new Password("Hell0W0rld");
        assertEquals("Hell0W0rld", password.getPassword());
    }

    @Override
    @Test
    public void passwordEquals() throws NullArgumentException, WrongFormatException {
        Password password = new Password("Hell0W0rld");
        assertTrue(password.equals(password));
    }

    @Override
    @Test
    public void passwordNotEquals() throws NullArgumentException, WrongFormatException {
        Password password1 = new Password("Hell0W0rld");
        Password password2 = new Password("Hi345benu");
        assertFalse(password1.equals(password2));
    }

    @Override
    @Test
    public void passwordEquals2() throws NullArgumentException, WrongFormatException {
        Password password1 = new Password("Hell0W0rld");
        Password password2 = new Password("Hell0W0rld");
        assertTrue(password1.equals(password2));
    }
}
