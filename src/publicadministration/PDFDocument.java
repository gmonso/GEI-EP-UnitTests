package publicadministration;

import data.DocPath;
import exceptions.BadPathException;
import exceptions.NullArgumentException;
import exceptions.WrongFormatException;

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

    public PDFDocument() throws NullArgumentException, WrongFormatException {
        this.creatDate = new Date();
        this.path = new DocPath("C:\\Users\\Public\\Documents\\test.pdf");
        this.file = new File(this.path.getPath());
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
            // revisar
            Files.move(Path.of(this.path.getPath()), Path.of(destPath.getPath()), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new IOException("The document could not be moved");
        }
        this.path = destPath;
    }

    // Opens the document at the path indicated
    public void openDoc(DocPath path) throws IOException, BadPathException {
        if (path == null) throw new BadPathException();
        try {
            File file = new File(path.getPath());
            Desktop.getDesktop().open(file);
        } catch (IOException ex) {
            throw new IOException("The file cannot be opened");
        }
        this.path = path;
    }
}