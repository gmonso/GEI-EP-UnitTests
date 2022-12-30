package interfaces;
import exceptions.NullArgumentException;
import exceptions.WrongFormatException;

public interface NifTest_Int {

    void correctNif() throws NullArgumentException, WrongFormatException;

    void nullNif();

    void badFormatNif();

    void nifEquals() throws NullArgumentException, WrongFormatException;

    void nifNotEquals() throws NullArgumentException, WrongFormatException;

    void nifEquals2() throws NullArgumentException, WrongFormatException;
}
