package com.aaa.mrlang.controller;

import com.aaa.mrlang.entity.Pager;
import com.aaa.mrlang.service.UserService;
import com.aaa.mrlang.service.UserServiceImpl;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 郎老师
 * @company AAA软件教育
 * @title ${NAME}
 * @date 2019/9/20 21:01
 */
@WebServlet(name = "UserServlet",urlPatterns = "/user.action")
public class UserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        UserService userService=new UserServiceImpl();
        String sPageNo= request.getParameter("pageNo");
        if(sPageNo==null) sPageNo="1";

        Pager pager = userService.query(Integer.parseInt(sPageNo));


        //将Java转换成json字符串
//       String str= JSON.toJSONString(pager);
        String str= JSON.toJSONStringWithDateFormat(pager,"yyyy-MM-dd");

        PrintWriter writer = response.getWriter();

        writer.print(str);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          doPost(request, response);
    }
}
