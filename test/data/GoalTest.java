package data;


import exceptions.GoalTypeException;
import exceptions.NullArgumentException;
import exceptions.WrongFormatException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GoalTest {

    @Test
    public void NullGoal() {
        Throwable exception;
        exception = assertThrows(NullArgumentException.class, () -> new Goal(null, Goal.GoalType.OTHER));
        assertEquals("Goal is null", exception.getMessage());
    }

    @Test
    public void WrongFormatGoal() {
        Throwable exception = assertThrows(WrongFormatException.class, () -> new Goal("123", Goal.GoalType.OTHER));
        assertEquals("Goal is not in the correct format", exception.getMessage());
    }

    @Test
    public void CorrectGoal() throws NullArgumentException, WrongFormatException, GoalTypeException {
        Goal goal = new Goal("Narco", Goal.GoalType.STUDENT);
        assertEquals("Narco", goal.getGoal());
        assertEquals(Goal.GoalType.STUDENT, goal.getType());
        assertNotEquals(Goal.GoalType.OTHER, goal.getType());
    }
}
