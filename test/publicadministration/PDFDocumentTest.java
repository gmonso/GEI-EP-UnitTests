package publicadministration;

import data.DocPath;
import exceptions.NullArgumentException;
import exceptions.WrongFormatException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class PDFDocumentTest {
    private PDFDocument pdfDocument;

    @BeforeEach
    void init() throws NullArgumentException, WrongFormatException, IOException {
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

    @Test
    void testOpenDocIOException() {
        assertThrows(IOException.class, () -> {
            pdfDocument.openDoc(null);
        });
    }

    @Test
    void testMoveDoc() throws IOException, NullArgumentException, WrongFormatException {
        String currentPath = System.getProperty("user.dir");
        Files.createDirectories(Path.of(currentPath + "/testmove"));
        assertThrows(IOException.class, () -> pdfDocument.moveDoc(null));
        assertDoesNotThrow(() -> pdfDocument.moveDoc(new DocPath(currentPath + "/testmove/new_file.pdf")));
        assertEquals(currentPath + "/testmove/new_file.pdf", pdfDocument.getPath().getPath());
        Files.deleteIfExists(Path.of(currentPath + "/testmove/new_file.pdf"));
        Files.deleteIfExists(Path.of(currentPath + "/testmove/"));
        Files.deleteIfExists(Path.of(currentPath + "/new_file.pdf"));
    }

    @Test
    void testOpenDoc() throws IOException, NullArgumentException, WrongFormatException {
        String currentPath = System.getProperty("user.dir");
        if (!Files.exists(Path.of(currentPath + "/open_file.pdf"))) {
            Files.createFile(Path.of(currentPath + "/open_file.pdf"));
        }
        assertThrows(IOException.class, () -> pdfDocument.openDoc(null));
        assertDoesNotThrow(() -> pdfDocument.openDoc(new DocPath(currentPath + "/open_file.pdf")));
        Files.delete(Path.of(currentPath + "/open_file.pdf"));
    }



}
