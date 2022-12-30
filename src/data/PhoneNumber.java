package data;

import exceptions.NullArgumentException;
import exceptions.WrongFormatException;

import java.security.SecureRandom;
import java.util.Objects;
import java.util.stream.IntStream;

public class PhoneNumber {
    private String phoneNumber;

    public PhoneNumber(String number) throws NullArgumentException, WrongFormatException {
        if (number == null) throw new NullArgumentException("Phone number is null");
        if (!this.correctFormat(number)) throw new WrongFormatException("Phone number is not in the correct format");
        this.phoneNumber = number;
    }

    private boolean correctFormat(String phoneNumber) {
        return phoneNumber.length() == 9;
    }

    public void setPhoneNumber(String num) {
        this.phoneNumber = num;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhoneNumber that)) return false;
        return Objects.equals(getPhoneNumber(), that.getPhoneNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPhoneNumber());
    }

    public static PhoneNumber getInstance() throws NullArgumentException, WrongFormatException {
        SecureRandom random = new SecureRandom();
        String phoneNumber = IntStream.range(0, 8)
                .mapToObj(i -> String.valueOf(random.nextInt(10)))
                .reduce((a, b) -> a + b)
                .get();
        return new PhoneNumber('6' + phoneNumber);
    }


}