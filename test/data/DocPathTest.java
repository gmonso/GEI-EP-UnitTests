package data;


import exceptions.NullArgumentException;
import exceptions.WrongFormatException;
import interfaces.DocPathTest_Int;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class DocPathTest implements DocPathTest_Int {

    @Override
    @Test
    public void nullDocPath() {
        Throwable exception = assertThrows(NullArgumentException.class, () -> new DocPath(null));
        assertEquals("Path is null", exception.getMessage());
    }

    @Override
    @Test
    public void wrongFormatDocPath() {
        Throwable exception = assertThrows(WrongFormatException.class, () -> new DocPath("Cy\\Users\\User\\wer..."));
        assertEquals("Path is not in the correct format", exception.getMessage());
    }

    @Override
    @Test
    public void goodDocPath() throws NullArgumentException, WrongFormatException {
        DocPath docPath = new DocPath("C:\\Users\\User\\Desktop\\test.pdf");
        assertEquals("C:\\Users\\User\\Desktop\\test.pdf", docPath.getPath());
    }

    @Override
    @Test
    public void docPathEquals() throws NullArgumentException, WrongFormatException {
        DocPath docPath = new DocPath("C:\\Users\\User\\Desktop\\test.pdf");
        assertTrue(docPath.equals(docPath));
    }

    @Override
    @Test
    public void docPathNotEquals() throws NullArgumentException, WrongFormatException {
        DocPath docPath1 = new DocPath("C:\\Users\\User\\Desktop\\test.pdf");
        DocPath docPath2 = new DocPath("C:\\Users\\User\\Desktop\\test2.pdf");
        assertFalse(docPath1.equals(docPath2));
    }

    @Override
    @Test
    public void docPathEquals2() throws NullArgumentException, WrongFormatException {
        DocPath docPath1 = new DocPath("C:\\Users\\User\\Desktop\\test.pdf");
        DocPath docPath2 = new DocPath("C:\\Users\\User\\Desktop\\test.pdf");
        assertTrue(docPath1.equals(docPath2));
    }
}
