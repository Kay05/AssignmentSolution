package com.kuda.common.dao.impl;

import com.kuda.common.dao.UserDao;
import com.kuda.common.rest.RestService;

/**
 * Created by kuda on 10/14/2016.
 */
public class UserDaoImpl implements UserDao {

    private RestService restService;

    public UserDaoImpl() {
    }

    public UserDaoImpl(RestService restService) {
        this.restService = restService;
    }

    public RestService getRestService() {
        return this.restService;
    }

    public void setRestService(RestService restService) {
        this.restService = restService;
    }


    @Override
    public boolean isValidUser(String username, String password) {
        try {
            StringBuffer response = restService.authenticate(username,password);
            if(response.toString().contains("token"))
                return true;
            else
                return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
