package publicadministration;

import data.Nif;
import data.Reference;
import exceptions.NullArgumentException;
import exceptions.WrongFormatException;

import java.math.BigDecimal;
import java.util.Date;

public class CardPayment {
    // The information associated to the payment realized via internet
    private final Reference reference; // The code of the operation
    private final Nif nif; // The nif of the user
    private final Date date; // The date of the operation
    private final BigDecimal imp; // The import of the payment


    public CardPayment(Nif nif, BigDecimal imp) throws NullArgumentException, WrongFormatException {
        this.reference = Reference.getInstance(); // "1234567890";
        this.nif = nif;
        this.date = new Date(2,2,2);
        this.imp = imp;
    }

    public Reference getReference() {
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
                "reference=" + reference +
                ", nif=" + nif +
                ", date=" + date +
                ", imp=" + imp +
                '}';
    }
}
