package publicadministration;

import data.Nif;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.Date;
import java.util.stream.IntStream;

public class CardPayment {
    // The information associated to the payment realized via internet
    private final String reference; // The code of the operation
    private final Nif nif; // The nif of the user
    private final Date date; // The date of the operation
    private final BigDecimal imp; // The import of the payment


    public CardPayment (Nif nif, BigDecimal imp) {
        this.reference = this.generateReference(); // "1234567890";
        this.nif = nif;
        this.date = new Date();
        this.imp = imp;
    }

    private String generateReference() {
        SecureRandom random = new SecureRandom();
        return IntStream.range(0, 20)
                .mapToObj(i -> String.valueOf(random.nextInt(10)))
                .reduce((a, b) -> a + b)
                .get();
    }


    public String getReference() {
        return reference;
    }

    public Nif getNif() {
        return nif;
    }

    public Date getDate() {
        return date;
    }

    public BigDecimal getImport() {
        return imp;
    }


    @Override
    public String toString() {
        return "CardPayment{" +
                "reference='" + reference + '\'' +
                ", nif=" + nif +
                ", date=" + date +
                ", import =" + imp +
                '}';
    }
}
