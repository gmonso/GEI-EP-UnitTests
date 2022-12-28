package data;


import exceptions.GoalTypeException;
import exceptions.NullArgumentException;
import exceptions.WrongFormatException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class GoalTest {

    Goal G;

    @BeforeEach
    public void init() throws NullArgumentException, GoalTypeException, WrongFormatException {
        G = new Goal("87946518645132", Goal.GoalType.WORKER);
    }

    @Test
    public void ConstructorTest() {
        assertEquals("87946518645132", G.getGoal());
        assertEquals(Goal.GoalType.WORKER, G.getType());
    }

    @Test
    public void NullGoal(){
        try {
            new Goal(null, Goal.GoalType.STUDENT);
        } catch (NullArgumentException n) {
            System.out.println(n.getMessage());
        } catch (WrongFormatException w){
            System.out.println(w.getMessage());
        } catch (GoalTypeException e) {
            fail();
        }
    }

    /*@Test
    public void WrongGoalType(){
        try{
            new Goal ("1235689", Goal.GoalType.STUDENT);
        } catch (NullArgumentException n) {
            fail();
        } catch (WrongFormatException w){
            fail();
        } catch (GoalTypeException e) {
            System.out.println(e.getMessage());
        }
    }
*/
}
