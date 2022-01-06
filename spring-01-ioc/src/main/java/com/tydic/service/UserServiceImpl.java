package com.tydic.service;

import com.tydic.dao.UserDao;
import com.tydic.dao.UserDaoImpl;

public class UserServiceImpl implements UserService{
    private UserDao userDao;
    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }
    public int getUser() {
        userDao.getUser();
        return 0;
    }
}
