package data;

import exceptions.NullArgumentException;
import exceptions.WrongFormatException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestNif {

    @BeforeEach
    void init() throws NullArgumentException, WrongFormatException {
        Nif nif = new Nif("12345678J");
    }
    @Test
    public void correctNif() {

    }

    @Test
    public void nullNif() {

    }

    @Test
    public void badFormatNif() {

    }
}
