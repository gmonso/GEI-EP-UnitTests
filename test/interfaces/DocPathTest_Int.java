package interfaces;

import exceptions.NullArgumentException;
import exceptions.WrongFormatException;

public interface DocPathTest_Int {

    void nullDocPath();

    void wrongFormatDocPath();

    void goodDocPath() throws NullArgumentException, WrongFormatException;

    void docPathEquals() throws NullArgumentException, WrongFormatException;

    void docPathNotEquals() throws NullArgumentException, WrongFormatException;

    void docPathEquals2() throws NullArgumentException, WrongFormatException;
}
