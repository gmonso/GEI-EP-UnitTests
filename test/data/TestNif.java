package data;

import exceptions.NullArgumentException;
import exceptions.WrongFormatException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestNif {
    Nif nif;

    @BeforeEach
    void init() throws NullArgumentException, WrongFormatException {
        nif = new Nif("12345678A");
    }

    @Test
    public void ConstructorTest(){
        assertEquals("12345678A", nif.getNif());
    }
    @Test
    public void correctNif() {
        try {
            new Nif("12345678J");
        } catch (NullArgumentException | WrongFormatException ignored) {
            fail();
        }
        System.out.println("Correct Nif");
    }

    @Test
    public void nullNif() {
        try {
            new Nif(null);
        } catch (NullArgumentException ignored) {
            System.out.println(ignored.getMessage());
        } catch (WrongFormatException ignored) {
            fail();
        }


    }

    @Test
    public void badFormatNif() {
        try {
            new Nif("A2345D6J");
        } catch (WrongFormatException ignored) {
            System.out.println(ignored.getMessage());
        } catch (NullArgumentException e) {
            fail();
        }
    }
}
