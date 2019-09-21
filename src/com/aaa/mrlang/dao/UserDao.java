package com.aaa.mrlang.dao;


import com.aaa.mrlang.entity.Pager;
import com.aaa.mrlang.entity.SysUser;

import java.util.List;
import java.util.Map;

public interface UserDao {
    List queryAll();
    Map queryById(int id);
    int update(SysUser user);
    int delete(int id);
    int create(SysUser user);

    /**
     * 分页查询
     * @param pageNo 当前的页码
     * @param pageSize 每页的条数
     * @return PageBean的对象
     */
    Pager query(int pageNo, int pageSize, Map condition);

    Pager query(int pageNo, int pageSize);
}
