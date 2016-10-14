package com.kuda.common.dao;

/**
 * Created by kuda on 10/14/2016.
 */
public interface UserDao {
    public boolean isValidUser(String username, String password);
}
