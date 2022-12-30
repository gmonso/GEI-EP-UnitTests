package publicadministration;

import data.Nif;
import exceptions.NullArgumentException;
import exceptions.WrongFormatException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class CardPaymentTest {
    private CardPayment cardPayment;
    private Nif nif;
    private BigDecimal imp;

    @BeforeEach
    void init() throws NullArgumentException, WrongFormatException {
        nif = new Nif("12345678Z");
        imp = new BigDecimal(100);
        cardPayment = new CardPayment(nif, imp);
    }

    @Test
    public void testConstructor() {
        assertEquals(nif, cardPayment.getNif());
        assertEquals(imp, cardPayment.getImport());
    }

    @Test
    public void testGetNif() {
        assertEquals(nif, cardPayment.getNif());
    }

    @Test
    public void testGetImport() {
        assertEquals(imp, cardPayment.getImport());
    }

    @Test
    void testNullConstructor() {
        try {
            CardPayment c = new CardPayment(null, null);
        } catch (Exception ignored) {
            fail();
        }
    }

    @Test
    public void testToString() {
        assertNotNull(cardPayment.toString());
    }
}
