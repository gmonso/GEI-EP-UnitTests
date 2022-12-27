package publicadministration;

import data.DocPath;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Date;

public class PDFDocument {
    private final Date creatDate;
    private DocPath path;
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
        if (destPath == null) {
            throw new IOException("The destination path is null");
        }
        try {

            Files.move((Path) this.path, (Path) destPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            // handle the exception
        }
        this.path = destPath;

    }

    // Opens the document at the path indicated
    public void openDoc(DocPath path) throws IOException {
        if (path == null) throw new IOException("The path is null");
        try {
            File file = new File(path.toString());
            Desktop.getDesktop().open(file);
        } catch (IOException ex) {
            throw new IOException("The file cannot be opened");
        }
    }
}
