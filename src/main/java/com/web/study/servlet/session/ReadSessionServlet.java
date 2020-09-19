/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.study.servlet.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/servlet/session/read")
public class ReadSessionServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        PrintWriter out = resp.getWriter();
        if(session != null){
            out.println("Read Session OK!");
            out.println("Session id: " + session.getId());
            //讀取 sesion attribute 資料
            Enumeration<String> enums = session.getAttributeNames();
            while (enums.hasMoreElements()) {
                String name = enums.nextElement();
                out.println(name + " : " + session.getAttribute(name));
                
            }
        } else {
            out.println("Session Timeout");
        }
    }
    
}
