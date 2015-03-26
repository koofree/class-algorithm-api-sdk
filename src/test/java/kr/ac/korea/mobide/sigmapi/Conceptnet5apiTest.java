package kr.ac.korea.mobide.sigmapi;

import org.junit.Test;

/**
 * Created by Koo Lee on 3/24/2015.
 */
public class Conceptnet5apiTest {
    private static final String query = "hungry";

    @Test
    public void test() {
        for (Conceptnet5Data data : Conceptnet5api.getData(query, 10)) {
            for (Conceptnet5Item item : data.getEdges()) {
                System.out.println(item);
            }
        }
    }
}
