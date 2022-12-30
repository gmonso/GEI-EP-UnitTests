package publicadministration;

import exceptions.NullArgumentException;
import interfaces.CrimConvictionInt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CrimConvictionExceptionsTest implements CrimConvictionInt {
    CrimConviction crimC;

    @BeforeEach
    public void setter() {
        crimC = new CrimConviction(null, null, null);
    }

    @Override
    @Test
    public void testGetter() throws NullArgumentException {

        try{
            assertEquals(crimC.getDate(),new Date(2022, 12,13) );
            assertEquals(crimC.getOffense(), "The offense");
            assertEquals(crimC.getSentence(), "20 years");
        } catch (NullArgumentException ignored){

        try {
            assertEquals(crimC.getDate(), new Date(2022, 12, 13));
            assertEquals(crimC.getOffense(), "The offense");
            assertEquals(crimC.getSentence(), "20 years");
        } catch (NullArgumentException ignored) {


        }

    }
}
