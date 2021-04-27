package com.jilingy.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description:
 * @Author: yangjiling
 * @Email: jilingy@foxmail.com
 * @Date: 2021/4/23
 **/
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取前端参数
        String method =req.getParameter("method");
        if (method.equals("add")){
            req.getSession().setAttribute("msg","执行了add");
        }
        if (method.equals("delete")){
            req.getSession().setAttribute("msg","执行了delete");
        }
        //调用业务层
        //试图转发或者重定向
        req.getRequestDispatcher("/WEB-INF/jsp/test.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }}
