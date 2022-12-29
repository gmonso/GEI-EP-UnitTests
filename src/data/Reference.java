package data;

import exceptions.NullArgumentException;
import exceptions.WrongFormatException;

import java.security.SecureRandom;
import java.util.Objects;
import java.util.stream.IntStream;

public class Reference {

    private String reference;

    public Reference(String reference) throws NullArgumentException, WrongFormatException {
        if (reference == null) throw new NullArgumentException("Reference is null");
        if (!this.correctFormat(reference)) throw new WrongFormatException("Reference is not in the correct format");
        this.reference = reference;
    }

    private boolean correctFormat(String reference) {
        if (reference.length() < 3) return false;
        return reference.length() <= 20;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reference that)) return false;
        return Objects.equals(getReference(), that.getReference());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getReference());
    }

    @Override
    public String toString() {
        return "CardPaymentReference{" +
                "reference='" + reference + '\'' +
                '}';
    }

    public static Reference getInstance() throws NullArgumentException, WrongFormatException {
        SecureRandom random = new SecureRandom();
        String reference = IntStream.range(0, 20)
                .mapToObj(i -> String.valueOf(random.nextInt(10)))
                .reduce((a, b) -> a + b)
                .get();
        return new Reference(reference);
    }
}
