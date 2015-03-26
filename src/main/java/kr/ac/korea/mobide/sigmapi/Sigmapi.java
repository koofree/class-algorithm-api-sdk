package kr.ac.korea.mobide.sigmapi;

import java.util.*;

/**
 * Created by Koo Lee on 2014-09-11.
 */
public abstract class Sigmapi extends AbstractLogApi {

    public static boolean view_log = false;

    private static final String[] except_strings = {null, "null"};
    private static final String category_url = "http://mobide.korea.ac.kr/apiservice/category";
    private static final String similarity_url = "http://mobide.korea.ac.kr/apiservice/similarity";
    private static JsonRequester<Score[]> categoryRequester = new JsonRequester<Score[]>(
            category_url, Score[].class);

    private static JsonRequester<Score[]> similarityRequester = new JsonRequester<Score[]>(
            similarity_url, Score[].class);

    public static List<Score> getScores(String query, int count) {
        log("category query : " + query + "(" + count + ")");

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("query", query);
        params.put("count", Integer.toString(count));

        if (Arrays.asList(except_strings).contains(query)) {
            params.put("query", "");
        }

        return Arrays.asList(categoryRequester.get(params));
    }

    public static List<Score> getSimilarity(String query, String[] targets) {
        String targetString = "";

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("query", query);
        ArrayList<String> list = new ArrayList<String>();
        for (String target : targets) {
            list.add(target);
            targetString += target + ", ";
        }

        log("similarity query : " + query + " | " + targetString);

        params.put("targets", list);

        if (Arrays.asList(except_strings).contains(query)) {
            params.put("query", "");
        }

        return Arrays.asList(similarityRequester.get(params));
    }


}
