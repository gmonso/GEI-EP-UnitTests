package data;

import exceptions.NullArgumentException;
import exceptions.WrongFormatException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmallCodeTest {

    @Test
    public void nullSmallCode(){
        Throwable exception = assertThrows(NullArgumentException.class, () -> new SmallCode(null));
        assertEquals("SmallCode is null", exception.getMessage());
    }

    @Test
    public void wrongSmallCode(){
        Throwable exception = assertThrows(WrongFormatException.class, () -> new SmallCode("12853"));
        assertEquals("SmallCode is not in the correct format", exception.getMessage());
    }

    @Test
    public void correctSmallCode() throws NullArgumentException, WrongFormatException {
        SmallCode smallCode = new SmallCode("123");
        assertEquals("123", smallCode.getCode());
    }

    @Test
    public void smallCodeEquals() throws NullArgumentException, WrongFormatException {
        SmallCode smallCode = new SmallCode("123");
        assertTrue(smallCode.equals(smallCode));
    }

    @Test
    public void smallCodeNotEquals() throws NullArgumentException, WrongFormatException {
        SmallCode smallCode1 = new SmallCode("123");
        SmallCode smallCode2 = new SmallCode("456");
        assertFalse(smallCode1.equals(smallCode2));
    }

    @Test
    public void smallCodeEquals2() throws NullArgumentException, WrongFormatException {
        SmallCode smallCode1 = new SmallCode("123");
        SmallCode smallCode2 = new SmallCode("123");
        assertTrue(smallCode1.equals(smallCode2));
    }
}
