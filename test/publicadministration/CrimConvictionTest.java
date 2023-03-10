package publicadministration;

import exceptions.NullArgumentException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class CrimConvictionTest {
    private Date commitDate;
    private String offense;
    private String sentence;
    private CrimConviction crimConviction;

    @BeforeEach
    void init() {
        commitDate = new Date();
        offense = "offense";
        sentence = "sentence";
        crimConviction = new CrimConviction(commitDate, offense, sentence);
    }

    @Test
    void testGetDate() throws NullArgumentException {
        assertEquals(commitDate, crimConviction.getDate());
    }

    @Test
    void testGetOffense() throws NullArgumentException {
        assertEquals(offense, crimConviction.getOffense());
    }

    @Test
    void testGetSentence() throws NullArgumentException {
        assertEquals(sentence, crimConviction.getSentence());
    }

    @Test
    public void testConstructor() throws NullArgumentException {
        assertEquals(commitDate, crimConviction.getDate());
        assertEquals(offense, crimConviction.getOffense());
        assertEquals(sentence, crimConviction.getSentence());
    }

    // test to string is string
    @Test
    void testToString() {
        assertNotNull(crimConviction.toString());
    }

    // test null constructor
    @Test
    void testNullConstructor() {
        try {
            CrimConviction c = new CrimConviction(null, null, null);
        } catch (Exception ignored) {
            fail();
        }
    }

}
