package interfaces;

import exceptions.NullArgumentException;
import exceptions.WrongFormatException;

public interface DigitalSignTest_Int {

    void correctDigitalSign() throws NullArgumentException, WrongFormatException;

    void nullDigitalSign();

    void badFormatDigitalSign();

    void digitalSignEquals() throws NullArgumentException, WrongFormatException;

    void digitalSignNotEquals() throws NullArgumentException, WrongFormatException;

    void digitalSignEquals2() throws NullArgumentException, WrongFormatException;
}
