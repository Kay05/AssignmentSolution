package com.kuda.common.rest;

/**
 * Created by kuda on 10/14/2016.
 */
public interface RestServiceAuth {

    public StringBuffer authenticate(String username, String password) throws Exception;
}
