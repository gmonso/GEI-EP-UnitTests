package data;

import exceptions.NullArgumentException;
import exceptions.WrongFormatException;
import interfaces.CardNumberTest_Int;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CardNumberTest implements CardNumberTest_Int {

    @Test
    public void correctCardNumber() throws NullArgumentException, WrongFormatException {
        CardNumber cardNumber = new CardNumber("1234567890123456");
        assertEquals("1234567890123456", cardNumber.getCardNumber());
    }

    @Test
    public void nullCardNumber() {
        Throwable exception = assertThrows(NullArgumentException.class, () -> new CardNumber(null));
        assertEquals("Card number is null", exception.getMessage());
    }

    @Test
    public void badFormatCardNumber() {
        Throwable exception = assertThrows(WrongFormatException.class, () -> new CardNumber("12345678901234567890"));
        assertEquals("Card number is not in the correct format", exception.getMessage());
    }

    @Test
    public void cardNumberEquals() throws NullArgumentException, WrongFormatException {
        CardNumber cardNumber = new CardNumber("1234567890123456");
        assertTrue(cardNumber.equals(cardNumber));
    }

    @Test
    public void cardNumberNotEquals() throws NullArgumentException, WrongFormatException {
        CardNumber cardNumber1 = new CardNumber("1234567890123456");
        CardNumber cardNumber2 = new CardNumber("1234567890123457");
        assertFalse(cardNumber1.equals(cardNumber2));
    }

    @Test
    public void cardNumberEquals2() throws NullArgumentException, WrongFormatException {
        CardNumber cardNumber1 = new CardNumber("1234567890123456");
        CardNumber cardNumber2 = new CardNumber("1234567890123456");
        assertTrue(cardNumber1.equals(cardNumber2));
    }
}
