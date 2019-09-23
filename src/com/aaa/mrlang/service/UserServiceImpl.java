package com.aaa.mrlang.service;


import com.aaa.mrlang.dao.UserDao;
import com.aaa.mrlang.dao.impl.UserDaoImpl;
import com.aaa.mrlang.entity.PageInfo;

import java.util.Map;

public class UserServiceImpl implements UserService {

    //实例化dao
    private UserDao dao=new UserDaoImpl();


    @Override
    public PageInfo query(int start, int pageSize, Map condation) {
        return dao.query(start,pageSize,condation);
    }


}
