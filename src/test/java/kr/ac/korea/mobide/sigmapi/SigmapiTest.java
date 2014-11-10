package kr.ac.korea.mobide.sigmapi;

import org.junit.Test;

/**
 * Created by Koo Lee on 2014-09-11.
 */
public class SigmapiTest {

    private static final String query = "asteroids soccer";
    private static final String[] targets = {"football", "england", "playground", "science"};

    @Test
    public void test() {
        for (Score score : Sigmapi.getScores(query, 10)) {
            System.out.println(score);
        }

        for (Score score : Sigmapi.getSimilarity(query, targets)) {
            System.out.println(score);
        }
    }
}
