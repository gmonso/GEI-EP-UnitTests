package interfaces;

import exceptions.NullArgumentException;
import exceptions.WrongFormatException;

public interface SmallCodeTest_Int {

    void nullSmallCode();

    void wrongSmallCode();

    void correctSmallCode() throws NullArgumentException, WrongFormatException;

    void smallCodeEquals() throws NullArgumentException, WrongFormatException;

    void smallCodeNotEquals() throws NullArgumentException, WrongFormatException;

    void smallCodeEquals2() throws NullArgumentException, WrongFormatException;
}
