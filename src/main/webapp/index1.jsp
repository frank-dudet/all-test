<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>HelloJSP</title>
    <c:set var="contextPath" value="${pageContext.request.contextPath}" scope="application"/>
</head>
<body>
<%
    out.println("Hello JSP!");    //在网页上打印输出"Hello JSP！"语句
%>
</body>
</html>