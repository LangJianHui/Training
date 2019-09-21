package com.aaa.mrlang.dao.impl;

import com.aaa.mrlang.dao.BaseDao;
import com.aaa.mrlang.dao.RoleMenuDao;

import java.util.List;

/**
 * @ClassName RoleMenuDaoImpl
 * @Author 郎建辉
 * @Date 2019/5/9 11:15
 * @Version 1.0
 */
public class RoleMenuDaoImpl extends BaseDao implements RoleMenuDao {
    @Override
    public List queryMenusByRoleId(int roleid) {
        String sql="select m.id,m.parent_id,m.name,1 as open, \n" +
                "(case when role_id is not null then true else false end) as checked \n" +
                "from sys_menu m left join \n" +
                "(select * from sys_role_menu rm where rm.role_id=? ) as rm \n" +
                "on m.id=rm.menu_id";
        Object[] params=new Object[]{roleid};
        return executeQuery(sql,params);
    }
}
