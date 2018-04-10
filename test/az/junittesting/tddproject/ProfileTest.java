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
    Answer answerIsThereRelocation;

    @Before
    public void initializeProfile(){
        profile = new Profile();
    }
    
    @Before
    public void createQuestionIsThereRelocation(){
        questionIsThereRelocation = new BooleanQuestion(1, "Relocation package?");
    }

    @Before
    public void createAnswerIsThereRelocation(){

    }

    @Test
    public void matchNothingWhenProfileEmpty(){

        Criterion criterion = new Criterion(answerIsThereRelocation, Weight.DontCare);

        boolean result = profile.matches(criterion);

        assertFalse(result);
    }

    @Test
    public void matchesWhenProfileContainsMatchingAnswer(){

        profile.add(answerIsThereRelocation);
        Criterion criterion = new Criterion(answerIsThereRelocation, Weight.Important);

        boolean result = profile.matches(criterion);

        assertFalse(result);
    }

}
