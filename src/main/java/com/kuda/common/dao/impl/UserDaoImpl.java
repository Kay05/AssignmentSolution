package com.kuda.common.dao.impl;

import com.kuda.common.dao.UserDao;
import com.kuda.common.rest.RestServiceAuth;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kuda on 10/14/2016.
 */
public class UserDaoImpl implements UserDao {

    private RestServiceAuth restServiceAuth;

    public UserDaoImpl() {
    }

    public UserDaoImpl(RestServiceAuth restServiceAuth) {
        this.restServiceAuth = restServiceAuth;
    }

    public RestServiceAuth getRestServiceAuth() {
        return this.restServiceAuth;
    }

    public void setRestServiceAuth(RestServiceAuth restServiceAuth) {
        this.restServiceAuth = restServiceAuth;
    }


    @Override
    public Map isValidUser(String username, String password) {
        try {
            StringBuffer response = restServiceAuth.authenticate(username,password);
            if(response.toString().contains("token")) {
                Map result = new HashMap<>();
                result.put("token", response);
                result.put("success", true);
                return result;
            }else
                return new HashMap<String, Boolean>(){{put("success", false);}};
        } catch (Exception e) {
            e.printStackTrace();
            return new HashMap<String, Boolean>(){{put("success", false);}};
        }
    }
}
