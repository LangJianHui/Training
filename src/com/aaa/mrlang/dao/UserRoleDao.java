package com.aaa.mrlang.dao;

import java.util.List;

public interface UserRoleDao {
    int delete(int userid);
    int add(int userid, String[] ids);

    //查询当前用户对应的角色
    List query(int userid);
}
