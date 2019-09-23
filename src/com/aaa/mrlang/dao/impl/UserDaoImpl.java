package com.aaa.mrlang.dao.impl;


import com.aaa.mrlang.dao.BaseDao;
import com.aaa.mrlang.dao.UserDao;
import com.aaa.mrlang.entity.PageInfo;
import com.aaa.mrlang.entity.SysUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName UserDaoImpl
 * @Author 郎建辉
 * @Date 2019/4/25 10:04
 * @Version 1.0
 */
public class UserDaoImpl extends BaseDao implements UserDao {


    @Override
    public Map queryById(int id) {
        String sql="select * from sys_user where user_id=?";
        List list= this.executeQuery(sql,id);
        if(list.size()>0){
            return (Map) list.get(0);
        }
        return null;
    }

    @Override
    public int update(SysUser user) {
        String sql="update sys_user set dept_id=?,user_name=?,email=?,phonenumber=?,sex=?, " +
                " where id=? ";
        return 1;
    }

    @Override
    public int delete(int id) {
        String sql=" delete from sys_user " +
                " where id=? ";
        return this.executeUpdate(sql,new Object[]{id});
    }

    @Override
    public int add(SysUser user) {
        String sql="insert into sys_user (username,pwd,emp_id) values(?,?,?) ";
        return 1;
    }

    @Override
    public PageInfo query(int start, int length, Map condition) {
        //默认的原始的sql命令
        String sql="select * from sys_user where 1=1 ";

        //动态改变字符串的值
        StringBuffer stringBuffer=new StringBuffer(sql);
        //创建集合用来保存参数
        List params=new ArrayList();
        if(condition!=null){
            //如果map中有该键值，说明需要查询该条件
            if(condition.containsKey("user_name")){
                stringBuffer.append(" and user_name like ? ");
                //绑定参数
                params.add("%"+condition.get("user_name")+"%");
            }
        }


        stringBuffer.append("  order by user_id desc limit ?,? ");
        //添加分页参数
        params.add(start);
        params.add(length);


        //将拼接好的内容转化为字符串
        sql=stringBuffer.toString();

        //查询的每页显示的数据的记录
        List list=this.executeQuery(sql,params.toArray());


         PageInfo pageInfo=new PageInfo(list, start, length, queryCount().intValue());
        //封装PageBean的实例

        return pageInfo;
    }



    public Long queryCount(){
        //根据用户名和密码进行查询操作
        String sql="select count(*) cnt from sys_user ";
        //获取到当前页要显示的数据集合
        List<Map> list=this.executeQuery(sql);
        return (Long) list.get(0).get("cnt");
    }
}
