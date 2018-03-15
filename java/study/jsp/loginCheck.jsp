<%--
  Created by IntelliJ IDEA.
  User: fan
  Date: 18-3-12
  Time: 下午7:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%request.setCharacterEncoding("UTF-8");%>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    if (username == null || password == null){
        response.sendRedirect("login.htm");
    }else {
        session.setAttribute("username",username);
        response.sendRedirect("chatRoom.jsp");
    }
%>