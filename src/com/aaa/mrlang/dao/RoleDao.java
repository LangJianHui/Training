package com.aaa.mrlang.dao;


import com.aaa.mrlang.entity.Pager;
import com.aaa.mrlang.entity.SysRole;

import java.util.List;
import java.util.Map;

public interface RoleDao {
    List queryAll();
    Map queryById(int id);
    int update(SysRole info);
    int delete(int id);
    int create(SysRole info);

    /**
     * 分页查询
     * @param curPage 当前的页码
     * @param pageSize 每页的条数
     * @return PageBean的对象
     */
    Pager query(int curPage, int pageSize);


}
