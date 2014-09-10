package kr.ac.korea.mobide.sigmapi;

import org.junit.Test;

/**
 * Created by Koo Lee on 2014-09-11.
 */
public class SigmapiTest {

    private static final String query = "asteroids";

    @Test
    public void test() {
        for (Score score : Sigmapi.getScores(query, 10)) {
            System.out.println(score);
        }
    }
}
