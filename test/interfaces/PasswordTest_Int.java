package interfaces;

import exceptions.NullArgumentException;
import exceptions.WrongFormatException;

public interface PasswordTest_Int {

    void nullPassword();

    void badFormat();

    void correctFormat() throws NullArgumentException, WrongFormatException;

    void passwordEquals() throws NullArgumentException, WrongFormatException;

    void passwordNotEquals() throws NullArgumentException, WrongFormatException;

    void passwordEquals2() throws NullArgumentException, WrongFormatException;
}
