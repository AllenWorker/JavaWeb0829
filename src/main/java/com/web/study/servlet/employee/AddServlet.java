/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.study.servlet.employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MB-study
 */
@WebServlet(name = "addservlet", urlPatterns = {"/servlet/employee/add"})
public class AddServlet extends HttpServlet {

    private static List<Map<String, String>> emps = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //resp.setContentType("text/plain;charset=utf-8");
        //resp.getWriter().print("此網頁不提供此方法的調用");
        //重新(外部)導向至employee_form.jsp
        //resp.sendRedirect("/JavaWeb0829/forms/employee_form.jsp");
        
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/forms/employee_form.jsp");
        rd.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String empName = req.getParameter("empName");
        String empSalary = req.getParameter("empSalary");
        String empSex = req.getParameter("empSex");
        String empType = req.getParameter("empType");

        //1.紀錄/建立 Map
        Map<String, String> emp = new LinkedHashMap<>();
        emp.put("empName", empName);
        emp.put("empSalary", empSalary);
        emp.put("empSex", empSex);
        emp.put("empType", empType);
        
        //2.儲存到emps
        emps.add(emp);
        
        //3.預備資料，將資料存放在 request 物件中
        req.setAttribute("emps", emps);
        
        //4.重導(內部)至 employee_form.jsp
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/forms/employee_form.jsp");
        rd.forward(req, resp);
    }

}
