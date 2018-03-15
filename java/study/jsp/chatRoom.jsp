<%--
  Created by IntelliJ IDEA.
  User: fan
  Date: 18-3-12
  Time: 下午7:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%request.setCharacterEncoding("UTF-8");%>
<%
    String username = (String) session.getAttribute("username");
    String chatText = request.getParameter("chatText");
    chatText = username + ":<br>&nbsp;&nbsp;" + chatText + "<br>";
    String allChatText = (String) application.getAttribute("allChatText");
    if (allChatText == null){
        allChatText = chatText;
    }else allChatText = chatText + allChatText;
    application.setAttribute("allChatText",allChatText);
    response.sendRedirect("sendText.htm");
%>