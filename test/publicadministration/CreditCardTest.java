package publicadministration;

import data.CardNumber;
import data.Nif;
import data.SmallCode;
import exceptions.NullArgumentException;
import exceptions.WrongFormatException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class CreditCardTest {
    private CreditCard creditCard;
    private Nif nif;
    private CardNumber cardNumb;
    private Date expirDate;
    private SmallCode svc;

    @BeforeEach
    void init() throws NullArgumentException, WrongFormatException {
        nif = new Nif("12345678Z");
        cardNumb = CardNumber.getInstance();
        expirDate = new Date();
        svc = new SmallCode("123445");
        creditCard = new CreditCard(nif, cardNumb, expirDate, svc);
    }

    @Test
    void testGetNif() throws NullArgumentException {
        assertEquals(nif, creditCard.getNif());
    }

    @Test
    void testGetCardNumber() {
        assertEquals(cardNumb, creditCard.getCardNumb());
    }

    @Test
    void testGetExpirDate() {
        assertEquals(expirDate, creditCard.getExpirDate());
    }

    @Test
    void testGetSvc() {
        assertEquals(svc, creditCard.getSvc());
    }

    @Test
    public void testConstructor() throws NullArgumentException, WrongFormatException {
        assertEquals(nif, creditCard.getNif());
        assertEquals(cardNumb, creditCard.getCardNumb());
        assertEquals(expirDate, creditCard.getExpirDate());
        assertEquals(svc, creditCard.getSvc());
    }

    // test toString is string
    @Test
    public void testToString() {
        assertNotNull(creditCard.toString());
    }

    // test null constructor
    @Test
    void testNullConstructor() {
        try {
            CreditCard c = new CreditCard(null, null, null, null);
        } catch (Exception ignored) {
            fail();
        }
    }


}
