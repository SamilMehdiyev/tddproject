package az.junittesting.tddproject;

import az.junittesting.tddproject.domain.Answer;
import az.junittesting.tddproject.domain.Bool;
import az.junittesting.tddproject.domain.BooleanQuestion;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Shamil on 10-Apr-18.
 */
public class AnswerTest{

    @Test
    public void matchAgainstNullAnswerReturnsFalse(){
        assertFalse(new Answer(new BooleanQuestion(0, ""), Bool.TRUE).match(null));
    }

}