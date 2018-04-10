package az.junittesting.tddproject;

import az.junittesting.tddproject.domain.*;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Shamil on 10-Apr-18.
 */
public class ProfileTest {

    @Test
    public void matchNothingWhenProfileEmpty(){

        Profile profile = new Profile();
        Question question = new BooleanQuestion(1, "Relocation package?");
        Criterion criterion = new Criterion(new Answer(question, Bool.TRUE), Weight.DontCare);

        boolean result = profile.matches(criterion);

        assertFalse(result);
    }

}
