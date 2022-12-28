package data;

import exceptions.NullArgumentException;
import exceptions.WrongFormatException;
import exceptions.GoalTypeException;

import java.util.Objects;

public class Goal {
    private final String goal;
    private final GoalType type;


    public Goal(String code, GoalType type) throws NullArgumentException, WrongFormatException, GoalTypeException {
        if (code == null) throw new NullArgumentException("Goal is null");
        if (!CorrectFormat(code)) throw new WrongFormatException("Goal is not in the correct format");
        if (!CorrectType(type)) throw new GoalTypeException("Goal is not of the correct type");
        this.goal = code;
        this.type = type;
    }

    public String getGoal() {
        return goal;
    }

    public GoalType getType() {
        return type;
    }

    public boolean CorrectFormat(String code) {
        if (code.length() < 3) return false;
        if (code.length() > 20) return false;
        if (!Character.isLetter(code.charAt(0))) return false;
        if (!Character.isLetter(code.charAt(code.length() - 1))) return false;
        int count = 0;
        for (int i = 0; i < code.length(); i++) {
            if (Character.isDigit(code.charAt(i))) count++;
        }
        return count >= 2;
    }

    public boolean CorrectType(GoalType type) {
        if (type == GoalType.OTHER) return true;
        if (type == GoalType.WORKER) return true;
        if (type == GoalType.STUDENT) return true;
        if (type == GoalType.UNEMPLOYED) return true;
        if (type == GoalType.RETIRED) return true;
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goal goal1 = (Goal) o;
        return Objects.equals(goal, goal1.goal) && type == goal1.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(goal, type);
    }

    @Override
    public String toString() {
        return "Goal{" + "goal='" + goal + '\'' + ", type=" + type + '}';
    }

    enum GoalType {
        WORKER, STUDENT, RETIRED, UNEMPLOYED, OTHER
    }
}
