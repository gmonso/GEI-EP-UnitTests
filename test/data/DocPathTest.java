package data;


import exceptions.NullArgumentException;
import exceptions.WrongFormatException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class DocPathTest {

    @Test
    public void nullDocPath() {
        Throwable exception = assertThrows(NullArgumentException.class, () -> new DocPath(null));
        assertEquals("Path is null", exception.getMessage());
    }

    @Test
    public void WrongFormatDocPath() {
        Throwable exception = assertThrows(WrongFormatException.class, () -> new DocPath("Cy\\Users\\User\\wer..."));
        assertEquals("Path is not in the correct format", exception.getMessage());
    }

    @Test
    public void goodDocPath() throws NullArgumentException, WrongFormatException {
        DocPath docPath = new DocPath("C:\\Users\\User\\Desktop\\test.txt");
        assertEquals("C:\\Users\\User\\Desktop\\test.txt", docPath.getPath());
    }
}
