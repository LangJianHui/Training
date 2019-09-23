package com.aaa.mrlang.dao;


import com.aaa.mrlang.entity.PageInfo;
import com.aaa.mrlang.entity.SysUser;

import java.util.Map;

public interface UserDao {
    Map queryById(int id);
    int update(SysUser user);
    int delete(int id);
    int add(SysUser user);

    /**
     * 分页查询
     * @param start 当前的页码
     * @param length 每页的条数
     * @return PageBean的对象
     */
    PageInfo query(int start, int length, Map condition);

}
