package interfaces;

import exceptions.NullArgumentException;
import exceptions.WrongFormatException;

public interface PhoneNumberTest_Int {

    void testPhoneNumber() throws NullArgumentException, WrongFormatException;

    void testPhoneNumberSetNumber() throws NullArgumentException, WrongFormatException;

    void testPhoneNumberNull();

    void testPhoneNumberWrongFormat();

    void testPhoneNumberEquals() throws NullArgumentException, WrongFormatException;

    void testPhoneNumberNotEquals() throws NullArgumentException, WrongFormatException;

    void testPhoneNumberEquals2() throws NullArgumentException, WrongFormatException;
}
