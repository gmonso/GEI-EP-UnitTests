package data;

import exceptions.NullArgumentException;
import exceptions.WrongFormatException;

import java.util.Objects;


public class Password {
    private final String password;

    public Password(String code) throws NullArgumentException, WrongFormatException {
        if (code == null) throw new NullArgumentException("Password is null");
        if (!correctFormat(code)) throw new WrongFormatException("Password is not in the correct format");
        this.password = code;
    }

    public String getPassword() {
        return password;
    }

    public boolean correctFormat(String code) {
        if (code.length() < 8) return false;
        if (code.length() > 20) return false;
        if (!Character.isLetter(code.charAt(0))) return false;
        if (!Character.isLetter(code.charAt(code.length() - 1))) return false;
        int count = 0;
        for (int i = 0; i < code.length(); i++) {
            if (Character.isDigit(code.charAt(i))) count++;
        }
        return count >= 2;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Password pass = (Password) o;
        return password.equals(pass.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(password);
    }

    @Override
    public String toString() {
        return "Password{" + "password='" + password + '\'' + '}';
    }
}
