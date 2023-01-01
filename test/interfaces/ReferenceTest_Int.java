package interfaces;

import exceptions.NullArgumentException;
import exceptions.WrongFormatException;
import org.junit.jupiter.api.Test;

public interface ReferenceTest_Int {

    void correctReference() throws NullArgumentException, WrongFormatException;

    @Test
    void setterReference() throws NullArgumentException, WrongFormatException;

    void nullReference();

    void badFormatReference();

    void referenceEquals() throws NullArgumentException, WrongFormatException;

    void referenceNotEquals() throws NullArgumentException, WrongFormatException;

    void referenceEquals2() throws NullArgumentException, WrongFormatException;
}
