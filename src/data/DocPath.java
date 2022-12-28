package data;
import exceptions.NullArgumentException;
import exceptions.WrongFormatException;

import java.nio.file.Paths;

public class DocPath {
    private final String path;

    public DocPath(String code) throws NullArgumentException, WrongFormatException {
        if (code == null) throw new NullArgumentException("Path is null");
        if (!CorrectFormat(code)) throw new WrongFormatException("Path is not in the correct format");
        this.path = code;
    }
    public String getPath() {
        return path;
    }
    public boolean CorrectFormat(String code) {
        if (!Paths.get(code).toFile().exists()) return false;
        return true;
    }
}
