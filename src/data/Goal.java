package data;
import exceptions.NullArgumentException;
import exceptions.WrongFormatException;

import java.util.Objects;

public class Goal {
    private final String goal;

    public Goal(String code) throws NullArgumentException, WrongFormatException {
        if (code == null) throw new NullArgumentException("Goal is null");
        if (!CorrectFormat(code)) throw new WrongFormatException("Goal is not in the correct format");
        this.goal = code;
    }
    public String getGoal() {
        return goal;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goal goal1 = (Goal) o;
        return Objects.equals(goal, goal1.goal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(goal);
    }

    @Override
    public String toString() {
        return "Goal{" +"goal='" + goal + '\'' +'}';
    }
}
