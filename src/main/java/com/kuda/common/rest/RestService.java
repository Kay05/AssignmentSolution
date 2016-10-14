package com.kuda.common.rest;

/**
 * Created by kuda on 10/14/2016.
 */
public interface RestService {

    public StringBuffer authenticate(String username, String password) throws Exception;
    public StringBuffer get(String url);
    public StringBuffer post(String url, String json) throws Exception;
}
