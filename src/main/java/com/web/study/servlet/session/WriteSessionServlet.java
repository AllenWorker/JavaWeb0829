/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.study.servlet.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/servlet/session/write")
public class WriteSessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true); //建立一個新session
        //將敏感性資料存入session中
        int salary = new Random().nextInt(100000);
        int age = new Random().nextInt(40);
        session.setAttribute("salary", salary);
        session.setAttribute("age", age);
        
        PrintWriter out = resp.getWriter();
        out.println("Session create ok!");
        out.println("Session id: " + session.getId());

    }

}
