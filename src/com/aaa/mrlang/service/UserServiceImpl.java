package com.aaa.mrlang.service;


import com.aaa.mrlang.dao.UserDao;
import com.aaa.mrlang.dao.impl.UserDaoImpl;
import com.aaa.mrlang.entity.Pager;

public class UserServiceImpl implements UserService {

    //实例化dao
    private UserDao dao=new UserDaoImpl();


    @Override
    public Pager query(int pageNo) {
        //设定每页的显示条数
        int  pageSize= 5;
        return dao.query(pageNo,pageSize);
    }


}
