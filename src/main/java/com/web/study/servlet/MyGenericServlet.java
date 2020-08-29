/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.study.servlet;

import java.io.IOException;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class MyGenericServlet extends GenericServlet{

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("init MyGenericServlet."); // 印在 TomEE 的console中
    }
    
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("service MyGenericServlet"); // 印在 TomEE 的console中
        res.getWriter().print("service MyGenericServlet"); //印在client端的瀏覽器中
    }
    
    @Override
    public void destroy() {
        System.out.println("destory MyGenericServlet"); // 印在 TomEE 的console中
    }
    
}
