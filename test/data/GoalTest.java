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

    @Test
    public void GoalEquals() throws NullArgumentException, WrongFormatException, GoalTypeException {
        Goal goal = new Goal("Narco", Goal.GoalType.STUDENT);
        assertTrue(goal.equals(goal));
    }

    @Test
    public void GoalNotEquals() throws NullArgumentException, WrongFormatException, GoalTypeException {
        Goal goal1 = new Goal("Narco", Goal.GoalType.STUDENT);
        Goal goal2 = new Goal("Traficant", Goal.GoalType.STUDENT);
        assertFalse(goal1.equals(goal2));
    }

    @Test
    public void GoalNotEquals2() throws NullArgumentException, WrongFormatException, GoalTypeException {
        Goal goal1 = new Goal("Narco", Goal.GoalType.STUDENT);
        Goal goal2 = new Goal("Narco", Goal.GoalType.OTHER);
        assertFalse(goal1.equals(goal2));
    }

    @Test
    public void GoalEquals2() throws NullArgumentException, WrongFormatException, GoalTypeException {
        Goal goal1 = new Goal("Narco", Goal.GoalType.STUDENT);
        Goal goal2 = new Goal("Narco", Goal.GoalType.STUDENT);
        assertTrue(goal1.equals(goal2));
    }
}
