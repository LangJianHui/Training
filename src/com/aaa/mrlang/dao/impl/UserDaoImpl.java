package com.aaa.mrlang.dao.impl;


import com.aaa.mrlang.dao.BaseDao;
import com.aaa.mrlang.dao.UserDao;
import com.aaa.mrlang.entity.Pager;
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
    public List queryAll() {
        String sql="select * from sys_user";
        return this.executeQuery(sql);
    }

    @Override
    public Map queryById(int id) {
        String sql="select * from sys_user where id=?";
        List list= this.executeQuery(sql,id);
        if(list.size()>0)
             return (Map) list.get(0);
        return null;
    }

    @Override
    public int update(SysUser user) {
        String sql="update sys_user set username=? " +
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
    public int create(SysUser user) {
        String sql="insert into sys_user (username,pwd,emp_id) values(?,?,?) ";
        return 1;
    }

    @Override
    public Pager query(int curPage, int pageSize, Map condition) {
        //默认的原始的sql命令
        String sql="select * from sys_user where 1=1 ";

        /*
        * select * from sys_user where 1=1 and username like ?
         * select * from sys_user where 1=1 username like ? and state=?
         * select * from sys_user where 1=1 and state=?
         * select * from sys_user where 1=1
        * */
        //动态改变字符串的值
        StringBuffer stringBuffer=new StringBuffer(sql);
        int startIndex=(curPage-1)*pageSize;
        //创建集合用来保存参数
        List params=new ArrayList();
        //如果map中有该键值，说明需要查询该条件
        if(condition.containsKey("username")){
            stringBuffer.append(" and username like ? ");
            //绑定参数
            params.add("%"+condition.get("username")+"%");
        }

//        if(condition.containsKey("state")){
//            //if state==-1  :or state in(0,1)
//            stringBuffer.append(" and state = ? ");
//            //绑定参数
//            params.add("%"+condition.get("state")+"%");
//        }

        stringBuffer.append("  order by id desc limit ?,? ");
        //添加分页参数
        params.add(startIndex);
        params.add(pageSize);


        //将拼接好的内容转化为字符串
        sql=stringBuffer.toString();

        //查询的每页显示的数据的记录
        List list=this.executeQuery(sql,params.toArray());

        //查询总条数
        sql="select count(*) c from sys_user ";
        Map map= (Map) this.executeQuery(sql).get(0);
        Long count= (Long) map.get("c");
//        System.out.println("总数:"+count);

        //封装PageBean的实例

        return null;
    }

    @Override
    public Pager query(int pageNo, int pageSize) {
        //根据用户名和密码进行查询操作
        String sql="select * from sys_user limit ?,?";
        Object[] params=new Object[]{(pageNo-1)*pageSize,pageSize};
        //获取到当前页要显示的数据集合
        List<Map> list=this.executeQuery(sql,params);

        //获取总条数
        Integer totalCount=queryCount().intValue();
        Pager pager=new Pager(pageNo,pageSize,list,totalCount);
        return pager;
    }

    public Long queryCount(){
        //根据用户名和密码进行查询操作
        String sql="select count(*) cnt from sys_user ";
        //获取到当前页要显示的数据集合
        List<Map> list=this.executeQuery(sql);
        return (Long) list.get(0).get("cnt");
    }
}
