package az.junittesting.tddproject;

import az.junittesting.tddproject.domain.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Shamil on 10-Apr-18.
 */
public class Profile_MatchesCriterionTest {

    private Profile profile;

    private Answer answerThereISRelocation, answerThereIsNotRelocation,
            answerDoesNotReimburseTuition, answerDoesReimburseTuition;

    @Before
    public void initializeProfile(){
        profile = new Profile();
    }

    @Before
    public void createQuestionAndAnswer(){
        Question questionIsThereRelocation = new BooleanQuestion(1, "Relocation package?");
        Question questionDoesReimburseTuition = new BooleanQuestion(2, "Reimburse Tuition?");

        answerThereISRelocation = new Answer(questionIsThereRelocation, Bool.TRUE);
        answerThereIsNotRelocation = new Answer(questionIsThereRelocation, Bool.FALSE);

        answerDoesReimburseTuition = new Answer(questionDoesReimburseTuition, Bool.TRUE);
        answerDoesNotReimburseTuition = new Answer(questionDoesReimburseTuition, Bool.FALSE);
    }

    @Test
    public void trueForAnyDoNotCareCriterion(){

        // Arrange
        profile.add(answerDoesNotReimburseTuition);
        Criterion criterion = new Criterion(answerDoesReimburseTuition, Weight.DontCare);

        // Assert
        assertTrue(profile.matches(criterion));

    }

    @Test
    public void falseWhenNoMatchingAnswerContained(){

        profile.add(answerThereIsNotRelocation);
        Criterion criterion = new Criterion(answerThereISRelocation, Weight.Important);

        boolean result = profile.matches(criterion);

        assertFalse(result);
    }
}
