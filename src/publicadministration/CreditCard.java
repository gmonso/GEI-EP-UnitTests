package publicadministration;

import data.Nif;
import data.SmallCode;

import java.util.Date;

public class CreditCard {
    // The payment information for using the card via internet
    private final Nif nif; // The nif of the user
    private final String cardNumb; // The number of the credit card
    private final Date expirDate; // The expiration date for the credit card
    private final SmallCode svc;     // The Safe Verification Code


    public CreditCard(Nif nif, String cardNumb, Date expirDate, SmallCode svc) {
        this.nif = nif;
        this.cardNumb = cardNumb;
        this.expirDate = expirDate;
        this.svc = svc;
    }

    public Nif getNif() {
        return nif;
    }

    public String getCardNumb() {
        return cardNumb;
    }

    public Date getExpirDate() {
        return expirDate;
    }

    public SmallCode getSvc() {
        return svc;
    }
    public boolean CorrectForm(){
        if(this.nif.getNif().length() <= 0 || this.cardNumb.length() <= 0 || this.expirDate == null || this.svc == null){
            return false;
        }
        return true;
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
