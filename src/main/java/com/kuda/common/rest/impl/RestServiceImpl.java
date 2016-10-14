package com.kuda.common.rest.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kuda.common.Project;
import com.kuda.common.rest.RestService;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by kuda on 10/14/2016.
 */
public class RestServiceImpl implements RestService {
    private static final String SERVICE_URL = "http://projectservice.staging.tangentmicroservices.com/api-explorer/";
    private static final String PROJECTS_URL = "http://projectservice.staging.tangentmicroservices.com:80/api/v1/projects/";
    private String token;

    public RestServiceImpl(String token) {
        this.token = token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public Object get(String param){
        try {
            URL url = new URL(PROJECTS_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Authorization", "Token "+sanitizeToken());

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));
            StringBuilder sb = new StringBuilder();
            String output;
            ///System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                sb.append(output);
                ///System.out.println(output);
            }

            ObjectMapper mapper = new ObjectMapper();
            Project[] projects = mapper.readValue(sb.toString(), Project[].class);
            conn.disconnect();
            return projects;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private String sanitizeToken(){
        StringBuffer th = new StringBuffer(token);
        th.delete(0,11);
        th.deleteCharAt(th.length() - 1);
        th.deleteCharAt(th.length() - 1);
        return th.toString();
    }

    @Override
    public StringBuffer post(String url, String json) throws Exception {
        return null;
    }
}
