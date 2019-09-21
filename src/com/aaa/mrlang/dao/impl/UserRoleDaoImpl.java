package com.aaa.mrlang.dao.impl;

import com.aaa.mrlang.dao.BaseDao;
import com.aaa.mrlang.dao.UserRoleDao;

import java.util.List;

/**
 * @ClassName UserRoleDaoImpl
 * @Author 郎建辉
 * @Date 2019/5/8 11:03
 * @Version 1.0
 */
public class UserRoleDaoImpl extends BaseDao implements UserRoleDao {
    @Override
    public int delete(int userid) {
//        String role_ids=Arrays.toString(ids).replaceAll("\\[|\\]","");
        String sql="delete from sys_user_role where user_id=?";
        return 1;
    }

    @Override
    public int add(int userid,String[] ids) {
        //this.getConnection();
        String sql="insert into sys_user_role(user_id,role_id) values(?,?)";
        for (String roleid:ids) {
        //   executeUpdate(sql,userid,roleid);
           //executeUpdateTrans(sql,userid,roleid);
        }
        //this.closeAll();
        return 0;
    }

    @Override
    public List query(int userid) {
        String sql="select ifnull(s1.role_id,0) checked,s2.id,s2.name from (select * from sys_user_role where user_id=? ) s1 RIGHT JOIN sys_role s2\n" +
                "on s1.role_id=s2.id ";
        return executeQuery(sql,new Object[]{userid});
    }
}
