package data;

import exceptions.NullArgumentException;
import exceptions.WrongFormatException;
import interfaces.CardNumberTest_Int;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CardNumberTest implements CardNumberTest_Int {


    @Override
    @Test
    public void correctCardNumber() throws NullArgumentException, WrongFormatException {
        CardNumber cardNumber = new CardNumber("1234567890123456");
        assertEquals("1234567890123456", cardNumber.getCardNumber());
    }

    @Override
    @Test
    public void setterCardNumber() throws NullArgumentException, WrongFormatException {
        CardNumber cardNumber = new CardNumber("1234567890123456");
        cardNumber.setCardNumber("4764789426575967");
        assertEquals("4764789426575967", cardNumber.getCardNumber());
        assertNotEquals("123467890123456", cardNumber.getCardNumber());
    }

    @Override
    @Test
    public void nullCardNumber() {
        Throwable exception = assertThrows(NullArgumentException.class, () -> new CardNumber(null));
        assertEquals("Card number is null", exception.getMessage());
    }

    @Override
    @Test
    public void badFormatCardNumber() {
        Throwable exception = assertThrows(WrongFormatException.class, () -> new CardNumber("12345678901234567890"));
        assertEquals("Card number is not in the correct format", exception.getMessage());
    }

    @Override
    @Test
    public void cardNumberEquals() throws NullArgumentException, WrongFormatException {
        CardNumber cardNumber = new CardNumber("1234567890123456");
        assertTrue(cardNumber.equals(cardNumber));
    }

    @Override
    @Test
    public void cardNumberNotEquals() throws NullArgumentException, WrongFormatException {
        CardNumber cardNumber1 = new CardNumber("1234567890123456");
        CardNumber cardNumber2 = new CardNumber("1234567890123457");
        assertFalse(cardNumber1.equals(cardNumber2));
    }

    @Override
    @Test
    public void cardNumberEquals2() throws NullArgumentException, WrongFormatException {
        CardNumber cardNumber1 = new CardNumber("1234567890123456");
        CardNumber cardNumber2 = new CardNumber("1234567890123456");
        assertTrue(cardNumber1.equals(cardNumber2));
    }
}
