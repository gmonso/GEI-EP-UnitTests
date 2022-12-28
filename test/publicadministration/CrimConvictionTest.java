package publicadministration;

import exceptions.NullArgumentException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import interfaces.*;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class CrimConvictionTest implements CrimConvictionInt {
    CrimConviction crimC;
    Date date;
    String offende;
    String sentc;
    @BeforeEach
    public void setup(){
        date = new Date(2022, 12,13);
        offende = "The offense";
        sentc = "20 years";
        crimC = new CrimConviction(date, offende, sentc);
    }
    @Override
    @Test
    public void testGetter() throws NullArgumentException {
        assertEquals(crimC.getDate(),new Date(2022, 12,13) );
        assertEquals(crimC.getOffense(), "The offense");
        assertEquals(crimC.getSentence(), "20 years");
    }
}
