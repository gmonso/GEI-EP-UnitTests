package publicadministration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

    // test to string is string
    @Test
    void testToString() {
        assertNotNull(crimConvictionsColl.toString());
    }

    // test null constructor
    @Test
    void testNullConstructor() {
        try {
            CrimConvictionsColl c = new CrimConvictionsColl();
        } catch (Exception ignored) {
            fail();
        }
    }
}
