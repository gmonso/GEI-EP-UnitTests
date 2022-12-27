package publicadministration;

import data.DocPath;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class PDFDocument {
    private final Date creatDate;
    private final DocPath path;
    private final File file;
    // Initializes attributes and emulates the document download at a default path

    public PDFDocument(Date creatDate, DocPath path, File file) {
        this.creatDate = creatDate;
        this.path = path;
        this.file = file;
    }

    public Date getCreatDate() {
        return creatDate;
    }

    public DocPath getPath() {
        return path;
    }

    public File getFile() {
        return file;
    }

    // Converts to String members Date & DocPath
    @Override
    public String toString() {
        return "PDFDocument{" +
                "creatDate=" + creatDate +
                ", path=" + path +
                ", file=" + file +
                '}';
    }

    // To implement only optionally
    // Moves the document to the destination path indicated
    public void moveDoc(DocPath destPath) throws IOException {
    }

    // Opens the document at the path indicated
    public void openDoc(DocPath path) throws IOException {
    }
}
