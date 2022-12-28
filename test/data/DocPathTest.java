package data;


import exceptions.NullArgumentException;
import exceptions.WrongFormatException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class DocPathTest {

    DocPath dp;

    @BeforeEach
    public void init() throws NullArgumentException, WrongFormatException {
        dp = new DocPath("C:\\Users\\User\\Desktop\\test.txt");
    }

    @Test
    public void ConstructorTest() {
        assertEquals("C:\\Users\\User\\Desktop\\test.txt", dp.getPath());
    }

    @Test
    public void nullDocPath() {
        try {
            new DocPath(null);
        } catch (NullArgumentException ignored) {
            System.out.println(ignored.getMessage());
        } catch (WrongFormatException ignored) {
            System.out.println(ignored.getMessage());
        }
    }

    @Test
    public void badFormatDocPath() {
        try {
            new DocPath("C:\\Users\\User\\Desktop\\test");
        } catch (WrongFormatException ignored) {
            System.out.println(ignored.getMessage());
        } catch (NullArgumentException ignored) {
            fail();
        }
    }
}
