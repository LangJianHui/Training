package com.aaa.mrlang.dao.impl;


import com.aaa.mrlang.dao.BaseDao;
import com.aaa.mrlang.dao.RoleDao;
import com.aaa.mrlang.entity.Pager;
import com.aaa.mrlang.entity.SysRole;

import java.util.List;
import java.util.Map;

/**
 * @ClassName RoleDaoImpl
 * @Author 郎建辉
 * @Date 2019/4/25 10:04
 * @Version 1.0
 */
public class RoleDaoImpl extends BaseDao implements RoleDao {
    @Override
    public List queryAll() {
        String sql="select * from sys_role";
        return this.executeQuery(sql);
    }

    @Override
    public Map queryById(int id) {
        String sql="select * from sys_role where id=?";
        List list= this.executeQuery(sql,id);
        if(list.size()>0)
             return (Map) list.get(0);
        return null;
    }

    @Override
    public int update(SysRole info) {
        String sql="update sys_role set name=?,description=?,state=? " +
                " where id=? ";
        return 1;
    }

    @Override
    public int delete(int id) {
        String sql=" delete from sys_role " +
                " where id=? ";
        return this.executeUpdate(sql,id);
    }

    @Override
    public int create(SysRole info) {
        String sql="insert into sys_role (name,description) values(?,?) ";
        return 1;
    }

    @Override
    public Pager query(int curPage, int pageSize) {
        String sql="select * from sys_role limit ?,?";
        int startIndex=(curPage-1)*pageSize;
        //查询的每页显示的数据的记录
        List list=this.executeQuery(sql,startIndex,pageSize);

        //查询总条数
        sql="select count(*) c from sys_role ";
        Map map= (Map) this.executeQuery(sql).get(0);
        Long count= (Long) map.get("c");
//        System.out.println("总数:"+count);

        //封装PageBean的实例

        return null;
    }
}
