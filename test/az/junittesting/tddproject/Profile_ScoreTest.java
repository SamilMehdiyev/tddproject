package az.junittesting.tddproject;

import az.junittesting.tddproject.domain.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * Created by Shamil on 10-Apr-18.
 */
public class Profile_ScoreTest {

    private Profile profile;
    private Answer answerThereISRelocation;
    private Criteria criteria;

    @Before
    public void initializeProfile(){
        profile = new Profile();
    }


    @Before
    public void createCriteria(){
        criteria = new Criteria();
    }
    
    @Before
    public void createQuestionAndAnswer(){
        Question questionIsThereRelocation = new BooleanQuestion(1, "Relocation package?");
        answerThereISRelocation = new Answer(questionIsThereRelocation, Bool.TRUE);
    }

    @Test
    public void ZeroWhenThereAreNoMatches(){

        criteria.add(new Criterion(answerThereISRelocation, Weight.Important));

        ProfileMatch match = profile.match(criteria);

        assertThat(match.getScore(), equalTo(0));
    }

}
