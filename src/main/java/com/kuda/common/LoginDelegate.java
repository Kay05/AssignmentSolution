package com.kuda.common;

import com.kuda.common.service.UserService;

/**
 * Created by kuda on 10/14/2016.
 */
public class LoginDelegate {
    private UserService userService;

    public UserService getUserService() {
        return this.userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public boolean isValidUser(String username, String password)
    {
        return userService.isValidUser(username, password);
    }

}
