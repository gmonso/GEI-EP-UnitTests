package publicadministration;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CitizenTest {
    @BeforeEach
    void init() {

    }

    @Test
    void NullNifConstructorCitizenTest() {
        try {
            Citizen c = new Citizen(null, "name", "address", "mobileNumb");
        } catch (Exception ignored) {
            fail();
        }
    }

    @Test
    void ValidConstructorCitizenTest() {
        try {
            Citizen c = new Citizen(new Nif("23242526J"), "name", "address", "mobileNumb");
        } catch (Exception ignored) {
            fail();

        }
    }

/*    @Test
    void addLine_NullArgumentTest() throws NullArgumentException, WrongFormatException, IncorrectTakingGuidelinesException {
        MedicalPrescription medp = new MedicalPrescription(3, new Date(), new Date(),
                new HealthCardID("BBBBBBBBAR123456789123456789"), new DigitalSignature(new byte[10]), new HashMap<>());
        try {
            medp.addLine(null, valid_line);
            fail();
        } catch (NullArgumentException ignored) {

        }
    }*/
}
