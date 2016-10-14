package com.kuda.common.dao.impl;

import com.kuda.common.dao.UserDao;
import com.kuda.common.rest.RestService;

/**
 * Created by kuda on 10/14/2016.
 */
public class UserDaoImpl implements UserDao {

    private RestService restService;

    public RestService getRestService() {
        return this.restService;
    }

    public void setRestService(RestService restService) {
        this.restService = restService;
    }


    @Override
    public boolean isValidUser(String username, String password) {
        return false;
    }
}
