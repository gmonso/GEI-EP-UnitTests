package data;

import exceptions.NullArgumentException;
import exceptions.WrongFormatException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.regex.Pattern;

public class DocPath {
    private final String path;

    public DocPath(String code) throws NullArgumentException, WrongFormatException {
        if (code == null) throw new NullArgumentException("Path is null");
        if (!correctPath(code)) throw new WrongFormatException("Path is not in the correct format");
        this.path = code;
    }

    public String getPath() {
        return path;
    }

    public boolean CorrectPath(String path) {
        return Pattern.matches("^.*\\.pdf$", path);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocPath docPath = (DocPath) o;
        return Objects.equals(path, docPath.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(path);
    }

    @Override
    public String toString() {
        return "DocPath{" + "path='" + path + '\'' + '}';
    }
}
