package data;

import exceptions.NullArgumentException;
import exceptions.WrongFormatException;

import java.util.Objects;

public class PhoneNumber {

    private String number;

    public PhoneNumber(String number) throws NullArgumentException, WrongFormatException {
        if (number == null) throw new NullArgumentException("Number is null");
        if (!correctNumber(number)) throw new WrongFormatException("Number is not in the correct format");
        this.number = number;
    }

    public boolean correctNumber(String number) {
        if (number.length() != 9) return false;
        return number.matches("[0-9]+");
    }

    public void setNumber(String num) {
        this.number = num;
    }

    public String getNumber() {
        return this.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumber that = (PhoneNumber) o;
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "number='" + number + '\'' +
                '}';
    }
}