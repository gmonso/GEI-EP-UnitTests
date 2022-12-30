package citizenmanagementplatform;

import citizenmanagementplatform.UnifiedPlatform;
import data.*;
import exceptions.*;
import interfaces.UnifiedPlatformTstg;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import publicadministration.*;
import services.CASdouble;
import services.CertAuthDouble;
import services.GPDdobule;
import services.JustMinDouble;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.ConnectException;
import java.util.Date;
import java.util.HashMap;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;

public class UnifiedPlatformTest implements UnifiedPlatformTstg {
    public CertAuthDouble cerAuth = new CertAuthDouble();
    public CASdouble CAS = new CASdouble();
    public GPDdobule GPD = new GPDdobule();
    public JustMinDouble justMin = new JustMinDouble();
    public UnifiedPlatform up;
    public Date d = new Date(2024,8,24);
    public Citizen ctz = new Citizen(new Nif("99999998C"),"Name", "user address", new PhoneNumber("666666666"), d);
    public CreditCard CC = new CreditCard(ctz.getNif(), new CardNumber("4444444444444444"), new Date(2029,5,12), new SmallCode("222"));
    public CrimConvictionsColl CColl;
    public CriminalRecordCertf crc;
    public DigitalSignature DS;
    public UnifiedPlatformTest() throws NullArgumentException, WrongFormatException {
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

    @Override
    @Test
    public void testEnterNifAndPinObt() throws IncorrectValDateException, NifNotRegisteredException, AnyMobileRegisteredException, NullArgumentException, ConnectException, WrongFormatException {
        up.enterNIFandPINobt(ctz.getNif(),d );
        SmallCode pinGuardat = up.usersPins.get(ctz.getNif().getNif());
        assertEquals(pinGuardat, this.cerAuth.getUserPin(ctz.getNif()));
    }

    @Override
    @Test
    public void testEnterPIN() throws NotValidPINException, NifNotRegisteredException, ConnectException, IncorrectValDateException, AnyMobileRegisteredException, NullArgumentException, WrongFormatException {
        up.enterNIFandPINobt(ctz.getNif(),d);
        SmallCode pinGuardat = up.usersPins.get(ctz.getNif().getNif());
        up.enterPIN(pinGuardat);
        assertTrue(up.sentTrue());
    }

    @Override
    @Test
    public void testEnterForm() throws NullArgumentException, WrongFormatException, IncorrectVerificationException, IncorrectFormException, ConnectException, NifNotRegisteredException, GoalTypeException {
        up.executeEnterForm(ctz, new Goal("Thesdfgoal", Goal.GoalType.STUDENT));
        String goal = this.GPD.getGoal(ctz.getNif().getNif());
        assertEquals(goal, "Thesdfgoal");
    }

    @Override
    @Test
    public void testEnterCardData() throws NotValidPaymentDataException, InsufficientBalanceException, IncorrectFormException, ConnectException {
        up.executeEnterCardData(CC);
        assertTrue(up.registered);
    }

    @Override
    @Test
    public void testObtainCertificate() throws DigitalSignatureException, IOException, BadPathException, NullArgumentException, WrongFormatException, GoalTypeException {
        up.setGoal();
        up.executeObtainCer();
        assertFalse(up.registered);
    }
}
