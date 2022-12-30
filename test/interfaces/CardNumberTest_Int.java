package interfaces;

import exceptions.NullArgumentException;
import exceptions.WrongFormatException;

public interface CardNumberTest_Int {

    void correctCardNumber() throws NullArgumentException, WrongFormatException;

    void nullCardNumber();

    void badFormatCardNumber();

    void cardNumberEquals() throws NullArgumentException, WrongFormatException;

    void cardNumberNotEquals() throws NullArgumentException, WrongFormatException;

    void cardNumberEquals2() throws NullArgumentException, WrongFormatException;
}
