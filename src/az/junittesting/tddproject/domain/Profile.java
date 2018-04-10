package az.junittesting.tddproject.domain;

/**
 * Created by Shamil on 10-Apr-18.
 */
public class Profile {
    private Answer answer;

    public boolean matches(Criterion criterion) {
        return answer != null;
    }

    public void add(Answer answer){
        this.answer = answer;
    }
}
