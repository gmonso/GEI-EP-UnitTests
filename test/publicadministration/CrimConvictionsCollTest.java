package publicadministration;

import exceptions.NullArgumentException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class CrimConvictionsCollTest {
    private int numConvs;
    private Set<CrimConviction> crimConvs;
    private CrimConvictionsColl crimConvictionsColl;

    @BeforeEach
    void init() {
        numConvs = 0;
        crimConvs = new HashSet<>();
        crimConvictionsColl = new CrimConvictionsColl();
    }

    @Test
    void testGetNumConvs() {
        assertEquals(numConvs, crimConvictionsColl.getNumConvs());
    }

    @Test
    void testGetCrimConvs() {
        assertEquals(crimConvs, crimConvictionsColl.getCrimConvs());
    }

    @Test
    void testAddCriminalConviction() {
        CrimConviction crmC = new CrimConviction(new Date(), "offense", "sentence");
        assertDoesNotThrow(() -> {
            crimConvictionsColl.addCriminalConviction(crmC);
        });
    }

    @Test
    void testGetCriminalConviction() {
        CrimConvictionsColl crmC = new CrimConvictionsColl();
        assertDoesNotThrow(() -> {
            crimConvictionsColl.getCriminalConviction(new Date());
        });
    }

    @Test
    void testAddAndGetCriminalConviction() throws NullArgumentException {
        Date date_today = new Date();
        Date date_towmorrow = new Date(date_today.getTime() + (1000 * 60 * 60 * 24 * 2));
        CrimConviction crmC1 = new CrimConviction(date_today, "offense", "sentence");
        CrimConviction crmC2 = new CrimConviction(date_towmorrow, "offense", "sentence");
        crimConvictionsColl.addCriminalConviction(crmC1);
        crimConvictionsColl.addCriminalConviction(crmC2);
        assertEquals(2, crimConvictionsColl.getNumConvs());
        assertEquals(crmC2, crimConvictionsColl.getCriminalConviction(date_towmorrow));
    }


    @Test
    void testToString() {
        assertNotNull(crimConvictionsColl.toString());
    }

    @Test
    void testNullConstructor() {
        try {
            CrimConvictionsColl c = new CrimConvictionsColl();
        } catch (Exception ignored) {
            fail();
        }
    }
}
