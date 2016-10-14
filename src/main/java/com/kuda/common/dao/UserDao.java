package com.kuda.common.dao;

import java.util.Map;

/**
 * Created by kuda on 10/14/2016.
 */
public interface UserDao {
    public Map isValidUser(String username, String password);
}
