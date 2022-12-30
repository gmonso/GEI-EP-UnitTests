package data;


import exceptions.GoalTypeException;
import exceptions.NullArgumentException;
import exceptions.WrongFormatException;
import interfaces.GoalTest_Int;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GoalTest implements GoalTest_Int {

    @Override
    @Test
    public void nullGoal() {
        Throwable exception;
        exception = assertThrows(NullArgumentException.class, () -> new Goal(null, Goal.GoalType.OTHER));
        assertEquals("Goal is null", exception.getMessage());
    }

    @Override
    @Test
    public void wrongFormatGoal() {
        Throwable exception = assertThrows(WrongFormatException.class, () -> new Goal("123", Goal.GoalType.OTHER));
        assertEquals("Goal is not in the correct format", exception.getMessage());
    }

    @Override
    @Test
    public void correctGoal() throws NullArgumentException, WrongFormatException, GoalTypeException {
        Goal goal = new Goal("Narco", Goal.GoalType.STUDENT);
        assertEquals("Narco", goal.getGoal());
        assertEquals(Goal.GoalType.STUDENT, goal.getType());
        assertNotEquals(Goal.GoalType.OTHER, goal.getType());
    }

    @Override
    @Test
    public void goalEquals() throws NullArgumentException, WrongFormatException, GoalTypeException {
        Goal goal = new Goal("Narco", Goal.GoalType.STUDENT);
        assertTrue(goal.equals(goal));
    }

    @Override
    @Test
    public void goalNotEquals() throws NullArgumentException, WrongFormatException, GoalTypeException {
        Goal goal1 = new Goal("Narco", Goal.GoalType.STUDENT);
        Goal goal2 = new Goal("Traficant", Goal.GoalType.STUDENT);
        assertFalse(goal1.equals(goal2));
    }

    @Override
    @Test
    public void goalNotEquals2() throws NullArgumentException, WrongFormatException, GoalTypeException {
        Goal goal1 = new Goal("Narco", Goal.GoalType.STUDENT);
        Goal goal2 = new Goal("Narco", Goal.GoalType.OTHER);
        assertFalse(goal1.equals(goal2));
    }

    @Override
    @Test
    public void goalEquals2() throws NullArgumentException, WrongFormatException, GoalTypeException {
        Goal goal1 = new Goal("Narco", Goal.GoalType.STUDENT);
        Goal goal2 = new Goal("Narco", Goal.GoalType.STUDENT);
        assertTrue(goal1.equals(goal2));
    }
}
