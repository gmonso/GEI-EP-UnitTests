package data;

import exceptions.NullArgumentException;
import exceptions.WrongFormatException;

import java.security.SecureRandom;
import java.util.Objects;
import java.util.stream.IntStream;

public class CardNumber {
    private String cardNumber;

    public CardNumber(String cardNumber) throws NullArgumentException, WrongFormatException {
        if (cardNumber == null) throw new NullArgumentException("Card number is null");
        if (!this.correctFormat(cardNumber)) throw new WrongFormatException("Card number is not in the correct format");
        this.cardNumber = cardNumber;
    }

    private boolean correctFormat(String cardNumber) {
        return cardNumber.length() == 16;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String toString() {
        return "CardNumber{" +
                "cardNumber='" + cardNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CardNumber that)) return false;
        return Objects.equals(getCardNumber(), that.getCardNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCardNumber());
    }

    public static CardNumber getInstance() throws NullArgumentException, WrongFormatException {
        SecureRandom random = new SecureRandom();
        String reference = IntStream.range(0, 20)
                .mapToObj(i -> String.valueOf(random.nextInt(10)))
                .reduce((a, b) -> a + b)
                .get();
        return new CardNumber(reference);
    }
}
