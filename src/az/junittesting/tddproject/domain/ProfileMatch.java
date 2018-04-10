/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/utj2 for more book information.
 ***/
package az.junittesting.tddproject.domain;

import java.util.ArrayList;
import java.util.List;

public class ProfileMatch {

    private List<Criterion> criteria;
    private int score;

    public void add(Criterion criterion){
        if (criteria == null)
                criteria = new ArrayList<>();
        criteria.add(criterion);
    }

    public int getScore() {

        if (criteria == null) return 0;

        for (Criterion criterion: criteria) {
            score += criterion.getScore();
        }
        return score;
    }

}
