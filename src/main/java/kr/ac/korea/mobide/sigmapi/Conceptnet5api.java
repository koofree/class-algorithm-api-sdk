package kr.ac.korea.mobide.sigmapi;

import java.util.*;

/**
 * Created by Koo Lee on 3/24/2015.
 */
public class Conceptnet5api extends AbstractLogApi {

    private static final String[] except_strings = {null, "null"};
    private static final String category_url = "http://conceptnet5.media.mit.edu/data/5.2/search";
    private static JsonRequester<Conceptnet5Data> categoryRequester = new JsonRequester<Conceptnet5Data>(
            category_url, Conceptnet5Data.class);

    public static List<Conceptnet5Data> getData(String query, int count) {
        log("conceptnet5 nodes query : " + query + "(" + count + ")");

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("surfaceText", "want");
        params.put("limit", Integer.toString(count));

        if (!Arrays.asList(except_strings).contains(query)) {
            params.put("nodes", "/c/en/" + query);
        } else {
            throw new RuntimeException();
        }

        return Arrays.asList(categoryRequester.get(params));
    }

}
