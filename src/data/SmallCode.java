package data;

import exceptions.NullArgumentException;
import exceptions.WrongFormatException;

import java.util.Objects;

public class SmallCode {
    private final String code;

    public SmallCode(String code) throws NullArgumentException, WrongFormatException {
        if (code == null) throw new NullArgumentException("SmallCode is null");
        if (!CorrectFormat(code)) throw new WrongFormatException("SmallCode is not in the correct format");
        this.code = code;
    }
    public boolean CorrectFormat(String code) {
        if (code.length() == 3) return true;
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SmallCode smallCode = (SmallCode) o;
        return Objects.equals(code, smallCode.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public String toString() {
        return "SmallCode{" + "code='" + code + '\'' + '}';
    }
}
