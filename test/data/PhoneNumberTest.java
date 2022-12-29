package data;

import exceptions.NullArgumentException;
import exceptions.WrongFormatException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PhoneNumberTest {

    @Test
    public void testPhoneNumber() throws NullArgumentException, WrongFormatException {
        PhoneNumber phoneNumber = new PhoneNumber("123456789");
        assertEquals("123456789", phoneNumber.getPhoneNumber());
    }

    @Test
    public void testPhoneNumberSetNumber() throws NullArgumentException, WrongFormatException {
        PhoneNumber phoneNumber = new PhoneNumber("123456789");
        phoneNumber.setPhoneNumber("987654321");
        assertEquals("987654321", phoneNumber.getPhoneNumber());
    }

    @Test
    public void testPhoneNumberNull() {
        Throwable exception = assertThrows(NullArgumentException.class, () -> new PhoneNumber(null));
        assertEquals("Phone number is null", exception.getMessage());
    }

    @Test
    public void testPhoneNumberWrongFormat() {
        Throwable exception = assertThrows(WrongFormatException.class, () -> new PhoneNumber("12345678"));
        assertEquals("Phone number is not in the correct format", exception.getMessage());
    }

    @Test
    public void testPhoneNumberEquals() throws NullArgumentException, WrongFormatException {
        PhoneNumber phoneNumber = new PhoneNumber("123456789");
        assertTrue(phoneNumber.equals(phoneNumber));
    }

    @Test
    public void testPhoneNumberNotEquals() throws NullArgumentException, WrongFormatException {
        PhoneNumber phoneNumber1 = new PhoneNumber("123456789");
        PhoneNumber phoneNumber2 = new PhoneNumber("987654321");
        assertFalse(phoneNumber1.equals(phoneNumber2));
    }

    @Test
    public void testPhoneNumberEquals2() throws NullArgumentException, WrongFormatException {
        PhoneNumber phoneNumber1 = new PhoneNumber("123456789");
        PhoneNumber phoneNumber2 = new PhoneNumber("123456789");
        assertTrue(phoneNumber1.equals(phoneNumber2));
    }
}
