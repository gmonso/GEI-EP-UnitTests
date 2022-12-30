package citizenmanagementplatform;

import data.*;
import exceptions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import publicadministration.*;
import services.CASdouble;
import services.CertAuthDouble;
import services.GPDdobule;
import services.JustMinDouble;

import java.math.BigDecimal;
import java.net.ConnectException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UnifiedPlatformExcTest {
    public CertAuthDouble cerAuth = new CertAuthDouble();
    public CASdouble CAS = new CASdouble();
    public GPDdobule GPD = new GPDdobule();
    public JustMinDouble justMin = new JustMinDouble();
    public UnifiedPlatform up;

    public Date d = new Date(2024,8,24);
    public Citizen ctz = new Citizen(new Nif("99999998C"),"Name", "user address", new PhoneNumber("666666666"), d);
    public CreditCard CC = new CreditCard(ctz.getNif(), new CardNumber("4444444444444444"), new Date(2029,5,12), new SmallCode("222"));

    public Date d = new Date(2024, 8, 24);
    public Citizen ctz = new Citizen(new Nif("99999998C"), "Name", "user address", "666666666", d);
    public CreditCard CC = new CreditCard(ctz.getNif(), "4444444444444444", new Date(2023, 5, 12), new SmallCode("222"));

    public CrimConvictionsColl CColl;
    public CriminalRecordCertf crc;
    public DigitalSignature DS;

    public UnifiedPlatformExcTest() throws NullArgumentException, WrongFormatException {
    }

    @BeforeEach
    void setup() throws NullArgumentException, WrongFormatException, GoalTypeException, IOException {
        DS = new DigitalSignature(new byte[5]);
        CColl = new CrimConvictionsColl();
        CColl.addCriminalConviction(new CrimConviction(new Date(2002, 2, 23), "offense", "20 Years"));
        crc = new CriminalRecordCertf(ctz.getNif(), ctz.getName(), new Goal("Thesdfgoal", Goal.GoalType.STUDENT), DS, CColl);
        setupCerAuth(cerAuth);
        setupCAS(CAS);
        setupGPD(GPD);
        setupJustMin(justMin);
        up = new UnifiedPlatform(justMin, CAS, GPD, cerAuth);
        setupUnifiedPlatform(up);
    }

    private void setupUnifiedPlatform(UnifiedPlatform up) {
        up.setCitizen(ctz);
    }

    private void setupCerAuth(CertAuthDouble cerAuth) throws NullArgumentException, WrongFormatException {
        cerAuth.addCitizen(ctz);
        cerAuth.addPhoneNumer(new PhoneNumber(ctz.getMobileNumb().getPhoneNumber()), ctz.getNif());
    }

    private void setupCAS(CASdouble cas) {
        cas.addBalance(CC, new BigDecimal(20000));
    }

    private void setupGPD(GPDdobule gpd) {
        gpd.addCitizen(ctz);
    }

    private void setupJustMin(JustMinDouble justMin) {
        justMin.add_CrimCertf(crc);
    }


    @Test
    public void testEnterNifAndPinObt() throws NifNotRegisteredException, AnyMobileRegisteredException, NullArgumentException, ConnectException, WrongFormatException {
        try {
            up.enterNIFandPINobt(ctz.getNif(), new Date(2023, 2, 3));
        } catch (IncorrectValDateException ignored) {

        }
    }

    @Test
    public void NifNotRegistered() throws AnyMobileRegisteredException, NullArgumentException, ConnectException, WrongFormatException, IncorrectValDateException {
        try {
            up.enterNIFandPINobt(new Nif("43888888A"), d);
        } catch (NifNotRegisteredException ignored) {

        }
    }

    @Test
    public void AnyMobileException() throws NifNotRegisteredException, NullArgumentException, ConnectException, WrongFormatException, IncorrectValDateException {
        try {

            ctz = new Citizen(new Nif("99995998C"),"Name", "user address", new PhoneNumber("666666666"), d);

            ctz = new Citizen(new Nif("99995998C"), "Name", "user address", "666666666", d);

            cerAuth.addCitizen(ctz);
            up.enterNIFandPINobt(ctz.getNif(), d);
        } catch (AnyMobileRegisteredException ignored) {

        }
    }


    @Test
    public void testValidPin() throws NotValidPINException, NifNotRegisteredException, ConnectException, IncorrectValDateException, AnyMobileRegisteredException, NullArgumentException, WrongFormatException {
        up.enterNIFandPINobt(ctz.getNif(), d);
        SmallCode pinGuardat = up.usersPins.get(ctz.getNif().getNif());
        up.enterPIN(pinGuardat);
        assertTrue(up.sentTrue());
    }


    @Test
    public void testIncorrectVerification() throws NullArgumentException, WrongFormatException, IncorrectFormException, ConnectException, NifNotRegisteredException {

        try{
            ctz = new Citizen(new Nif("99995998C"),"Name", "user address", new PhoneNumber("666666666"), d);
            up.executeEnterForm(ctz, new Goal("Thesdfgoal", Goal.GoalType.STUDENT));
        }catch (IncorrectVerificationException ignore) {

        try {
            ctz = new Citizen(new Nif("99995998C"), "Name", "user address", "666666666", d);
            up.executeEnterForm(ctz, new Goal("Rutinary32Check"));
        } catch (IncorrectVerificationException ignore) {


        } catch (GoalTypeException e) {
            throw new RuntimeException(e);
        }

    }


    @Test
    public void testInsufficientbalance() throws NotValidPaymentDataException, InsufficientBalanceException, IncorrectFormException, ConnectException {
        try {
            up.executeEnterCardData(CC);
            up.CAS.addBalance(CC, new BigDecimal(0));
            assertTrue(up.registered);
        } catch (InsufficientBalanceException ignore) {

        }
    }

}
