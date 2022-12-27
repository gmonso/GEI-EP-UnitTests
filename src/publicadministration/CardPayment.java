package publicadministration;

import data.Nif;

import java.math.BigDecimal;
import java.util.Date;

public class CardPayment {
    // The information associated to the payment realized via internet
    private final String reference; // The code of the operation
    private final Nif nif; // The nif of the user
    private final Date date; // The date of the operation
    private final BigDecimal bdImport; // The import of the payment


    public CardPayment(String reference, Nif nif, Date date, BigDecimal bdimport) {
        this.reference = reference;
        this.nif = nif;
        this.date = date;
        this.bdImport = bdimport;
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
        return bdImport;
    }


    @Override
    public String toString() {
        return "CardPayment{" +
                "reference='" + reference + '\'' +
                ", nif=" + nif +
                ", date=" + date +
                ", import =" + bdImport +
                '}';
    }
}
