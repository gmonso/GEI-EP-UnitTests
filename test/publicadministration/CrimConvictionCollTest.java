package publicadministration;

import exceptions.NullArgumentException;
import interfaces.CrimConvictionInt;
import interfaces.CrimConvictionsColl_Int;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class CrimConvictionCollTest implements CrimConvictionsColl_Int {
    CrimConvictionsColl CColl;
    CrimConviction cConv;
    @BeforeEach
    void setup(){
        cConv = new CrimConviction(new Date(2,2,2), "Sentence1", "10Years");
        CColl = new CrimConvictionsColl();
    }

    @Override
    @Test
    public void addTest() throws NullArgumentException {
        CColl.addCriminalConviction(cConv);
        assertEquals(1, CColl.getNumConvs());
    }

    @Override
    @Test
    public void getTest() throws NullArgumentException {
        CColl.addCriminalConviction(cConv);
        CrimConviction c = CColl.getCriminalConviction(new Date(2,2,2));
        assertEquals(c.toString(),new CrimConviction(new Date(2,2,2), "Sentence1", "10Years").toString() );
    }
}
