package publicadministration;

import exceptions.NullArgumentException;
import interfaces.CrimConvictionsColl_Int;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class CrimConvictionCollExceptionTest implements CrimConvictionsColl_Int {
    CrimConvictionsColl CColl;
    CrimConviction cConv;

    @BeforeEach
    void setup() {
        cConv = new CrimConviction(new Date(2, 2, 2), null, "10Years");
        CColl = new CrimConvictionsColl();
    }

    @Test
    void nullElemOnCrimConv() {
        try {
            CColl.addCriminalConviction(cConv);
        } catch (NullArgumentException ignored) {

        }
    }

    @Override
    @Test
    public void addTest() throws NullArgumentException {
        try {
            CColl.addCriminalConviction(null);
        } catch (NullArgumentException ignored) {

        }
    }

    @Override
    @Test
    public void getTest() throws NullArgumentException {
        try {
            CColl.getCriminalConviction(null);
        } catch (NullArgumentException ignored) {

        }
    }
}
