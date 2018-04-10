package az.junittesting.tddproject;

import az.junittesting.tddproject.domain.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Shamil on 10-Apr-18.
 */
public class ProfileTest {

    Profile profile;
    Question questionIsThereRelocation;
    Answer answerThereISRelocation, answerThereIsNotRelocation;

    @Before
    public void initializeProfile(){
        profile = new Profile();
    }
    
    @Before
    public void createQuestionAndAnswer(){
        questionIsThereRelocation = new BooleanQuestion(1, "Relocation package?");
        answerThereISRelocation = new Answer(questionIsThereRelocation, Bool.TRUE);
        answerThereIsNotRelocation = new Answer(questionIsThereRelocation, Bool.FALSE);
    }

    @Test
    public void matchNothingWhenProfileEmpty(){

        Criterion criterion = new Criterion(answerThereISRelocation, Weight.DontCare);

        boolean result = profile.matches(criterion);

        assertFalse(result);
    }

    @Test
    public void matchesWhenProfileContainsMatchingAnswer(){

        profile.add(answerThereIsNotRelocation);
        Criterion criterion = new Criterion(answerThereISRelocation, Weight.Important);

        boolean result = profile.matches(criterion);

        assertFalse(result);
    }

}
