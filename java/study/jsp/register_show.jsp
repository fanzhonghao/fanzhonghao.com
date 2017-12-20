<%@ page language="java" contentType="text/html" pageEncoding="gb2312"%>
<html>
  <head>
    <title>Register Info</title>
  </head>
  <body>
    <%
    String name=request.getParameter("name");
    if (name == null || name.equals("")) {
      response.sendRedirect("register.jsp");
    }else {
      session.setAttribute("name",name);
      String name2=(String) session.getAttribute("name");
      name2=new String(name2.getBytes("ISO-8859-1"),"GB2312");
      System.out.println("name: " + name2);
    }
    name = new String(name.getBytes("ISO-8859-1"),"GB2312");
    String year = request.getParameter("year");
    String month = request.getParameter("month");
    String gender=request.getParameter("gender");
    if (gender != null & gender.equals("0")) {
      gender = "Man";
    }else {
      gender = "Woman";
    }
    String nat = request.getParameter("nat");
    nat = new String(nat.getBytes("ISO-8859-1"),"GB2312");
    String[] likes = request.getParameterValues("like");
    String[] hobby={"Swimming","Reading","Dancing"};
    %>
    <p>
      USER INFO</p>
      Name: <%=name%><br>
      Birthday: <%=year%>.<%=month%><br>
      Sex: <%=gender%><br>
      Adderss: <%=nat%><br>
      hobby:
      <%
      if (likes != null) {
        for (int i = 0;i < likes.length ;i++ ) {
          int j = Integer.parseInt(likes[i]);
          out.print(hobby[j]);
          out.print(" ");
        }
      }
      %>
    </body>
  </html>
