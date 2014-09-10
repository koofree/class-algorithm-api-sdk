package kr.ac.korea.mobide.sigmapi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Koo Lee on 2014-09-11.
 */
public abstract class Sigmapi {

    private static final String score_url = "http://mobide.korea.ac.kr/apiservice/category";

    public static List<Score> getScores(String query, int count) {
        JsonRequester<Score[]> scoreRequester = new JsonRequester<Score[]>(
                score_url, Score[].class);

        Map<String, String> params = new HashMap<String, String>();
        params.put("query", query);
        params.put("count", Integer.toString(count));

        return Arrays.asList(scoreRequester.get(params));
    }
}
