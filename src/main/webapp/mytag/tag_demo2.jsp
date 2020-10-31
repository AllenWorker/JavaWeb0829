<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="/tlds/mytld" prefix="t"  %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            <t:hello name="Allen"/><p/>
            <t:hello /><p/>
            <t:bmi h="170" w="60"/><p/>
            <jsp:useBean id="random" class="java.util.Random" scope="page" />
            <t:lotto count="5">
                ${random.nextInt(50)}
            </t:lotto><p/>
            <t:search key="s">
                she sell sea shell on the sea shore
            </t:search><p/>
            <t:area r="15"/><p/>
            <t:add x="15" y="15" z="20"/><p/>
        </h1>
    </body>
</html>
