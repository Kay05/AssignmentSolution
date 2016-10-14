package com.kuda.common.service.impl;

import com.kuda.common.dao.UserDao;
import com.kuda.common.service.UserService;

/**
 * Created by kuda on 10/14/2016.
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserDao getUserDao() {
        return this.userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public boolean isValidUser(String username, String password) {
        return userDao.isValidUser(username, password);
    }
}
