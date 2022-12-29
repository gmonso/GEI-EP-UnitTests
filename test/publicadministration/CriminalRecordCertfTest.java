package publicadministration;

import data.DigitalSignature;
import data.Goal;
import data.Nif;
import exceptions.GoalTypeException;
import exceptions.NullArgumentException;
import exceptions.WrongFormatException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class CriminalRecordCertfTest {
    private Nif nif;
    private String name;
    private Goal goal;
    private DigitalSignature digSign;
    private CrimConvictionsColl crimConvs;
    private CriminalRecordCertf criminalRecordCertf;

    @BeforeEach
    // init all attrs and instance object
    void init() throws NullArgumentException, GoalTypeException, WrongFormatException {
        nif = new Nif("12345678Z");
        name = "John Doe";
        goal = new Goal("drft", Goal.GoalType.OTHER);
        digSign = new DigitalSignature(new byte[4]);
        crimConvs = new CrimConvictionsColl();
        criminalRecordCertf = new CriminalRecordCertf(nif, name, goal, digSign, crimConvs);
    }

    @Test
    public void testConstructor() throws NullArgumentException, GoalTypeException, WrongFormatException {
        assertEquals(nif, criminalRecordCertf.getNif());
        assertEquals(name, criminalRecordCertf.getName());
        assertEquals(goal, criminalRecordCertf.getGoal());
        assertEquals(digSign, criminalRecordCertf.getDigSign());
        assertEquals(crimConvs, criminalRecordCertf.getCrimConvs());
    }

    @Test
    public void testGetNif() {
        assertEquals(nif, criminalRecordCertf.getNif());
    }

    @Test
    public void testGetName() {
        assertEquals(name, criminalRecordCertf.getName());
    }

    @Test
    public void testGetGoal() {
        assertEquals(goal, criminalRecordCertf.getGoal());
    }

    @Test
    public void testGetDigSign() {
        assertEquals(digSign, criminalRecordCertf.getDigSign());
    }

    @Test
    public void testGetCrimConvs() {
        assertEquals(crimConvs, criminalRecordCertf.getCrimConvs());
    }

    @Test
    void testToString() {
        assertNotNull(criminalRecordCertf.toString());
    }

    @Test
    void testNullConstructor() {
        try {
            CriminalRecordCertf c = new CriminalRecordCertf(null, null, null, null, null);
        } catch (Exception ignored) {
            fail();
        }
    }

}
