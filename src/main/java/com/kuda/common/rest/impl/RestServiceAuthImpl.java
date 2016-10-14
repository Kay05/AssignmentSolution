package com.kuda.common.rest.impl;

import com.google.gson.Gson;
import com.kuda.common.rest.RestServiceAuth;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * Created by kuda on 10/14/2016.
 */
public class RestServiceAuthImpl implements RestServiceAuth {
    private static final String AUTH_URL = "http://userservice.staging.tangentmicroservices.com:80/api-token-auth/";
    private static final String USER_URL = "http://userservice.staging.tangentmicroservices.com/api-explorer/";
    private static final String SERVICE_URL = "http://projectservice.staging.tangentmicroservices.com/api-explorer/";
    private static final String PROJECTS_URL = "http://projectservice.staging.tangentmicroservices.com:80/api/v1/projects/";
    private Map token;
    private String token_;

    @Override
    public StringBuffer authenticate(String username, String password)throws Exception{
        URL url = new URL(AUTH_URL);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        String urlParameters = "username="+username+"&password="+password;
        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + AUTH_URL);
        System.out.println("Post parameters : " + urlParameters);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        token_ = response.toString();
        //putToken(response.toString());
        System.out.println(response.toString());

        return response;
    }

    public String getToken() {
        return token_;
    }

    private void putToken(String token) {
        if(!token.isEmpty() && token.contains("token") && token != null) {
            Gson convert = new Gson();
            Map t = convert.fromJson(token, Map.class);
            this.token = t;
        }
    }

}
