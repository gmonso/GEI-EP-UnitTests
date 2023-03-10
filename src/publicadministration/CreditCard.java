package publicadministration;

import data.CardNumber;
import data.Nif;
import data.SmallCode;

import java.util.Date;

public class CreditCard {
    // The payment information for using the card via internet
    private final Nif nif; // The nif of the user
    private final CardNumber cardNumb; // The number of the credit card
    private final Date expirDate; // The expiration date for the credit card
    private final SmallCode svc;     // The Safe Verification Code


    public CreditCard(Nif nif, CardNumber cardNumb, Date expirDate, SmallCode svc) {
        this.nif = nif;
        this.cardNumb = cardNumb;
        this.expirDate = expirDate;
        this.svc = svc;
    }

    public Nif getNif() {
        return nif;
    }

    public CardNumber getCardNumb() {
        return cardNumb;
    }

    public Date getExpirDate() {
        return expirDate;
    }

    public SmallCode getSvc() {
        return svc;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "nif=" + nif +
                ", cardNumb='" + cardNumb + '\'' +
                ", expirDate=" + expirDate +
                ", svc=" + svc +
                '}';
    }
}
