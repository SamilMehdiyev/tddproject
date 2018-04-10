package az.junittesting.tddproject.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shamil on 10-Apr-18.
 */
public class Profile {
    private Map<String, Answer> answers = new HashMap<>();

    public boolean matches(Criterion criterion) {
        Answer answer = getMatchingProfileAnswer(criterion);
        return criterion.getWeight() == Weight.DontCare ||
                criterion.getAnswer().match(answer);
    }

    public void add(Answer answer){
        answers.put(answer.getQuestionText(), answer);
    }

    private Answer getMatchingProfileAnswer(Criterion criterion){
        return answers.get(criterion.getAnswer().getQuestionText());
    }

    public boolean matches(Criteria criteria) {
        boolean matches = false;
        for (Criterion criterion: criteria){
            if (matches(criterion))
                matches = true;
            else if (criterion.getWeight() == Weight.Important)
                return false;
        }
        return matches;
    }

    public ProfileMatch match(Criteria criteria) {
        ProfileMatch profileMatch = new ProfileMatch();
        for(Criterion criterion: criteria){
            if(matches(criterion)){
                profileMatch.add(criterion);
            }
        }
        return profileMatch;
    }
}
