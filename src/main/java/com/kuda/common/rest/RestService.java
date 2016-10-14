package com.kuda.common.rest;

/**
 * Created by kuda on 10/14/2016.
 */
public interface RestService {
    public Object get(String param);
    public StringBuffer post(String url, String json) throws Exception;
}
