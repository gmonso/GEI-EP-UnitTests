package publicadministration;


import data.Nif;
import data.PhoneNumber;
import exceptions.NullArgumentException;
import exceptions.WrongFormatException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class CitizenTest {
    private Citizen citizen;
    private Nif nif;
    private String name;
    private String address;
    private PhoneNumber mobileNumb;

    @BeforeEach
    void init() throws NullArgumentException, WrongFormatException {
        nif = new Nif("12345678Z");
        name = "John Doe";
        address = "123 Main Street";
        mobileNumb = PhoneNumber.getInstance();
        citizen = new Citizen(nif, name, address, mobileNumb);
    }

    @Test
    public void testConstructor() throws NullArgumentException, WrongFormatException {
        assertEquals(nif, citizen.getNif());
        assertEquals(name, citizen.getName());
        assertEquals(address, citizen.getAddress());
        assertEquals(mobileNumb, citizen.getMobileNumb());
    }

    @Test
    public void testGetNif() throws NullArgumentException, WrongFormatException {
        assertEquals(nif, citizen.getNif());
    }

    @Test
    public void testGetName() throws NullArgumentException, WrongFormatException {
        assertEquals(name, citizen.getName());
    }

    @Test
    public void testGetAddress() throws NullArgumentException, WrongFormatException {
        assertEquals(address, citizen.getAddress());
    }

    @Test
    public void testGetMobileNumb() throws NullArgumentException, WrongFormatException {
        assertEquals(mobileNumb, citizen.getMobileNumb());
    }

    @Test
    void testNullConstructor() {
        try {
            Citizen c = new Citizen(null, null, null, null);
        } catch (Exception ignored) {
            fail();
        }
    }

    @Test
    public void testToString() {
        assertEquals(true, citizen.toString() instanceof String);
    }
}
