package az.junittesting.tddproject;

import az.junittesting.tddproject.domain.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

/**
 * Created by Shamil on 10-Apr-18.
 */
public class Profile_MatchesCriteriaTest {

    Profile profile;
    Question questionIsThereRelocation, questionDoesReimburseTuition;
    Answer answerThereISRelocation, answerDoesNotReimburseTuition;
    Criteria criteria;

    @Before
    public void initializeProfile(){
        profile = new Profile();
    }

    @Before
    public void createQuestionAndAnswer(){
        questionIsThereRelocation = new BooleanQuestion(1, "Relocation package?");
        questionDoesReimburseTuition = new BooleanQuestion(2, "Reimburse Tuition?");

        answerThereISRelocation = new Answer(questionIsThereRelocation, Bool.TRUE);
        answerDoesNotReimburseTuition = new Answer(questionDoesReimburseTuition, Bool.FALSE);
    }

    @Before
    public void createCriteria(){
        criteria = new Criteria();
    }

    @Test
    public void falseWhenNoneOfMultipleCriteriaMatch(){

        // Arrange
        profile.add(answerDoesNotReimburseTuition);
        criteria.add(new Criterion(answerThereISRelocation, Weight.Important));
        criteria.add(new Criterion(answerDoesNotReimburseTuition, Weight.Important));

        // Assert
        assertFalse(profile.matches(criteria));

    }

    @Test
    public void trueWhenAnyOfMultipleCriteriaMatch(){

        // Arrange
        profile.add(answerThereISRelocation);
        criteria.add(new Criterion(answerThereISRelocation, Weight.Important));
        criteria.add(new Criterion(answerDoesNotReimburseTuition, Weight.Important));

        // Assert
        assertFalse(profile.matches(criteria));

    }
}
