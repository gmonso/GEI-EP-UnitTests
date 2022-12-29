package data;

import exceptions.NullArgumentException;
import exceptions.WrongFormatException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SmallCodeTest {

    @Test
    public void NullSmallCode(){
        Throwable exception = assertThrows(NullArgumentException.class, () -> new SmallCode(null));
        assertEquals("SmallCode is null", exception.getMessage());
    }

    @Test
    public void WrongSmallCode(){
        Throwable exception = assertThrows(WrongFormatException.class, () -> new SmallCode("12853"));
        assertEquals("SmallCode is not in the correct format", exception.getMessage());
    }

    @Test
    public void CorrectSmallCode() throws NullArgumentException, WrongFormatException {
        SmallCode smallCode = new SmallCode("123");
        assertEquals("123", smallCode.getCode());
    }
}
