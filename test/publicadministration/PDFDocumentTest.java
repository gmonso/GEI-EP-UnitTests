package publicadministration;

import exceptions.NullArgumentException;
import exceptions.WrongFormatException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

public class PDFDocumentTest {
    private PDFDocument pdfDocument;

    @BeforeEach
    void init() throws NullArgumentException, WrongFormatException {
        pdfDocument = new PDFDocument();
    }

    @Test
    void testToString() {
        assertNotNull(pdfDocument.toString());
    }

    @Test
    void testGetPath() {
        assertNotNull(pdfDocument.getPath());
    }

    @Test
    void testGetFile(){
        assertNotNull(pdfDocument.getFile());
    }

    @Test
    void testGetCreateDate(){
        assertNotNull(pdfDocument.getCreateDate());
    }

    @Test
    void testNullConstructor() {
        try {
            PDFDocument p = new PDFDocument();
        } catch (Exception ignored) {
            fail();
        }
    }

}
