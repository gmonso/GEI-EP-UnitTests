package publicadministration;

import data.Nif;
import exceptions.NullArgumentException;
import exceptions.WrongFormatException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class CardPaymentTest {
    private CardPayment cardPayment;
    private String reference;
    private Nif nif;
    private Date date;
    private BigDecimal bdimport;

    @BeforeEach
    void init() throws NullArgumentException, WrongFormatException {
        nif = new Nif("12345678Z");
        reference = "123412341234";
        date = new Date();
        bdimport = new BigDecimal(100);
        cardPayment = new CardPayment(reference, nif, date, bdimport);

    }

    @Test
    public void testConstructor() {
        assertEquals(reference, cardPayment.getReference());
        assertEquals(nif, cardPayment.getNif());
        assertEquals(date, cardPayment.getDate());
        assertEquals(bdimport, cardPayment.getImport());
    }

    @Test
    public void testGetReference() {
        assertEquals(reference, cardPayment.getReference());
    }

    @Test
    public void testGetNif() {
        assertEquals(nif, cardPayment.getNif());
    }

    @Test
    public void testGetDate() {
        assertEquals(date, cardPayment.getDate());
    }

    @Test
    public void testGetImport() {
        assertEquals(bdimport, cardPayment.getImport());
    }

    @Test
    void testNullConstructor() {
        try {
            CreditCard c = new CreditCard(null, null, null, null);
        } catch (Exception ignored) {
            fail();
        }
    }

    @Test
    public void testToString() {
        assertEquals(true, cardPayment.toString() instanceof String);
    }
}
