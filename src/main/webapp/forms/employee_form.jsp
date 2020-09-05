<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.3/build/pure-min.css" integrity="sha384-cg6SkqEOCV1NbJoCu11+bm0NvBRc8IYLRGXkmNrqUBfTjmMYwNKPWBTIKyw9mHNJ" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body style="padding: 20px">
        <form class="pure-form pure-form-aligned" action="/JavaWeb0829/servlet/employee/add" method="post">
            <fieldset>
                <legend>Employee Forms</legend>
                <div class="pure-control-group">
                    <label for="empName">員工:</label>
                    <select id="empName-state" name="empName">
                        <option value="John">John 喬治</option>
                        <option value="Mary">Mary 瑪莉</option>
                        <option value="Mark">Mark 馬克</option>
                    </select>
                </div>
                <p/>
                <div class="pure-control-group">
                    <label for="empSalary">薪資:</label>
                    <input type="number" id="empSalary" placeholder="薪資" name="empSalary" />
                </div>
                <div class="pure-control-group">
                    <label for="aligned-weight">性別:</label>
                    <label for="empSex" class="pure-radio">
                        <input type="radio" id="empSex" name="empSex" value="1" checked="" />男</label>
                    <label for="empSex" class="pure-radio">
                        <input type="radio" id="empSex" name="empSex" value="2" checked="" />女</label>
                </div>
                <div class="pure-control-group">
                    <label for="empType">主管:</label> 
                    <input type="checkbox" id="empType" name="empType" value="true"/> 
                </div>
                <div class="pure-controls">
                    <button type="submit" class="pure-button pure-button-primary">Add</button>
                </div>
            </fieldset
        </form>
        <%
            List<Map<String, String>> emps = null;
            if(request.getAttribute("emps") != null) {
                emps = (List<Map<String,String>>)request.getAttribute("emps");
            }
        %>
        <table class="pure-table">
            <thead>
                <tr>
                    <th>員工</th>
                    <th>薪資</th>
                    <th>性別</th>
                    <th>主管</th>
                </tr>
            </thead>
            <%if (emps != null) {%>
            <%int total = 0;%>
            <tbody>
                <%for(Map<String, String> emp : emps) {%>
                <tr>
                    <td><%=emp.get("empName")%></td>
                    <td><%=String.format("%,d", Integer.parseInt(emp.get("empSalary")))%></td>
                    <td><%=(emp.get("empSex").equalsIgnoreCase("1") ? "男" : "女" )%></td>
                    <td><%=(emp.get("empType")!= null ? "是" : "否")%></td>
                </tr>
                <%total+= Integer.parseInt(emp.get("empSalary")); %>
                <%}%>
                <tr>
                    <td></td>
                    <td><%=String.format("%,d", total)%></td>
                    <td></td>
                    <td></td>
                </tr>
            </tbody>
            <%}%>
        </table>
    </body>
</html>
