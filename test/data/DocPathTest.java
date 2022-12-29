package data;


import exceptions.NullArgumentException;
import exceptions.WrongFormatException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


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


    @Test
    public void DocPathEquals() throws NullArgumentException, WrongFormatException {
        DocPath docPath = new DocPath("C:\\Users\\User\\Desktop\\test.txt");
        assertTrue(docPath.equals(docPath));
    }

    @Test
    public void DocPathNotEquals() throws NullArgumentException, WrongFormatException {
        DocPath docPath1 = new DocPath("C:\\Users\\User\\Desktop\\test.txt");
        DocPath docPath2 = new DocPath("C:\\Users\\User\\Desktop\\test2.txt");
        assertFalse(docPath1.equals(docPath2));
    }

    @Test
    public void DocPathEquals2() throws NullArgumentException, WrongFormatException {
        DocPath docPath1 = new DocPath("C:\\Users\\User\\Desktop\\test.txt");
        DocPath docPath2 = new DocPath("C:\\Users\\User\\Desktop\\test.txt");
        assertTrue(docPath1.equals(docPath2));
    }
}
