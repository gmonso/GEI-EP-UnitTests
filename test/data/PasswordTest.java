package data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PasswordTest {

    Password password;

    @BeforeEach
    public void init() {
        password = new Password("12345678");
    }
}
