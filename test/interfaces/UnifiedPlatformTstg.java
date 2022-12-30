package interfaces;

import exceptions.*;

import java.io.IOException;
import java.net.ConnectException;

public interface UnifiedPlatformTstg {
    void testEnterNifAndPinObt() throws IncorrectValDateException, NifNotRegisteredException, AnyMobileRegisteredException, NullArgumentException, ConnectException, WrongFormatException;
    void testEnterPIN() throws NotValidPINException, NifNotRegisteredException, ConnectException, IncorrectValDateException, AnyMobileRegisteredException, NullArgumentException, WrongFormatException;
    void testEnterForm() throws NullArgumentException, WrongFormatException, IncorrectVerificationException, IncorrectFormException, ConnectException, NifNotRegisteredException, GoalTypeException;
    void testEnterCardData() throws NotValidPaymentDataException, InsufficientBalanceException, IncorrectFormException, ConnectException;
    void testObtainCertificate() throws DigitalSignatureException, IOException, BadPathException, NullArgumentException, WrongFormatException, GoalTypeException;
}
