package az.junittesting.tddproject;

import az.junittesting.tddproject.domain.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * Created by Shamil on 10-Apr-18.
 */
public class ProfileTest {

    Profile profile;
    Question questionIsThereRelocation, questionDoesReimburseTuition;
    Answer answerThereISRelocation, answerThereIsNotRelocation, answerDoesNotReimburseTuition, answerDoesReimburseTuition;
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
        answerThereIsNotRelocation = new Answer(questionIsThereRelocation, Bool.FALSE);

        answerDoesReimburseTuition = new Answer(questionDoesReimburseTuition, Bool.TRUE);
        answerDoesNotReimburseTuition = new Answer(questionDoesReimburseTuition, Bool.FALSE);
    }
    
    @Before
    public void createCriteria(){
        criteria = new Criteria();
    }

    @Test
    public void scoreIsZeroWhenThereAreNoMatches(){

        criteria.add(new Criterion(answerThereISRelocation, Weight.Important));

        ProfileMatch match = profile.match(criteria);

        assertThat(match.getScore(), equalTo(0));
    }

    @Test
    public void matchesWhenProfileContainsMatchingAnswer(){

        profile.add(answerThereIsNotRelocation);
        Criterion criterion = new Criterion(answerThereISRelocation, Weight.Important);

        boolean result = profile.matches(criterion);

        assertFalse(result);
    }

    @Test
    public void doesNotMatchWhenNoneOfMultipleCriteriaMatch(){

        // Arrange
        profile.add(answerDoesNotReimburseTuition);
        criteria.add(new Criterion(answerThereISRelocation, Weight.Important));
        criteria.add(new Criterion(answerDoesNotReimburseTuition, Weight.Important));

        // Assert
        assertFalse(profile.matches(criteria));

    }

    @Test
    public void matchesWhenAnyOfMultipleCriteriaMatch(){

        // Arrange
        profile.add(answerThereISRelocation);
        criteria.add(new Criterion(answerThereISRelocation, Weight.Important));
        criteria.add(new Criterion(answerDoesNotReimburseTuition, Weight.Important));
        
        // Assert
        assertFalse(profile.matches(criteria));

    }

    @Test
    public void matchesWhenCriterionIsDontCare(){

        // Arrange
        profile.add(answerDoesNotReimburseTuition);
        Criterion criterion = new Criterion(answerDoesReimburseTuition, Weight.DontCare);

        // Assert
        assertTrue(profile.matches(criterion));

    }

}
