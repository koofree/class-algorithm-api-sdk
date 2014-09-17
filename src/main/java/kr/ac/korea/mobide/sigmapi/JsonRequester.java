package kr.ac.korea.mobide.sigmapi;


import com.google.gson.Gson;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import javax.xml.ws.http.HTTPException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.Map;

/**
 * Created by Koo Lee on 2014-09-11.
 */
public class JsonRequester<E> {

    private final String url;
    private final Gson gson;
    private final Class<E> eClass;

    public JsonRequester(String url, Class<E> eClass) {
        this.url = url;
        this.gson = new Gson();
        this.eClass = eClass;
    }

    public E get(Map<String, String> params) {
        E result = null;
        HttpClient httpClient = new HttpClient();

        // make get url
        String paramUrl = url;
        if (params.keySet().size() > 0) paramUrl += "?";
        for (String key : params.keySet()) {
            String _paramUrl = key + "=" + URLEncoder.encode(params.get(key)) + "&";
            paramUrl += _paramUrl;
        }
        int last = paramUrl.lastIndexOf("&");
        if (last > 0) paramUrl = paramUrl.substring(0, last);

        HttpMethod method = new GetMethod(paramUrl);
        try {
            int statusCode = httpClient.executeMethod(method);

            if (statusCode != HttpStatus.SC_OK) {
                System.err.println("Method failed: " + method.getStatusLine());
            }

            // Read the response body.
            BufferedReader br = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream()));

            // Convert into json object
            result = gson.fromJson(br, eClass);

            br.close();
        } catch (HTTPException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            method.releaseConnection();
        }

        return result;
    }
}
