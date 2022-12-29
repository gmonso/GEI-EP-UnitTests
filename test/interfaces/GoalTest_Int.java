package interfaces;

import exceptions.GoalTypeException;
import exceptions.NullArgumentException;
import exceptions.WrongFormatException;

public interface GoalTest_Int {

    void nullGoal();

    void wrongFormatGoal();

    void correctGoal() throws NullArgumentException, WrongFormatException, GoalTypeException;

    void goalEquals() throws NullArgumentException, WrongFormatException, GoalTypeException;

    void goalNotEquals() throws NullArgumentException, WrongFormatException, GoalTypeException;

    void goalNotEquals2() throws NullArgumentException, WrongFormatException, GoalTypeException;

    void goalEquals2() throws NullArgumentException, WrongFormatException, GoalTypeException;
}
