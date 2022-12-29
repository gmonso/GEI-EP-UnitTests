package publicadministration;

import data.DocPath;
import exceptions.NullArgumentException;
import exceptions.WrongFormatException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

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

}
