<%--
  Created by IntelliJ IDEA.
  User: fan
  Date: 18-3-12
  Time: 下午7:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%response.setHeader("refresh","3");
<%
    String allChatText = (String)application.getAttribute("allChatText");
    if (allChatText != null){
        out.print(allChatText);
    }else out.print("[聊天记录]");
%>