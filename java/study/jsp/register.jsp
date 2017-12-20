<%@ page language="java" contentType="text/html" pageEncoding="gb2312"%>
<html>
  <head>
    <title>Register</title>
  </head>
  <body>
    <p>
      <form action="register_show.jsp" method="post">
        <table>
          <tr>
            <td>Name: <input type="text" name="name"></td>
            <td>Birthday: <select name="year">
              <%
                for (int year= 1990;year < 2018; year++ ) {
                  %>
                  <option value="<%=year%>"><%=year%></option>
                <%
                }
                %>
              </select>year
              <select name="month">
                <%
                for (int month = 1;month  < 12;month++ ) {
                  %>
                  <option value="<%=month%>"><%=month%></option>
                  <%
                }
                %>
              </select>month
            </td>
          </tr>
          <tr>
            <td>Sex:<input type="radio" name="gender" value="0" checked>Man;&nbsp;&nbsp;
              <input type="radio" name="gender" value="1">Woman;</td>
              <td>Address: <input type="text" name="nat"></td>
          </tr>
          <tr>
            <td colspan="2">hobby:
              <input type="checkbox" name="like" value="0">Swimming&nbsp;&nbsp;
              <input type="checkbox" name="like" value="1">Reading&nbsp;&nbsp;
              <input type="checkbox" name="like" value="2">Dancing&nbsp;&nbsp;
            </td>
          </tr>
          <tr>
            <td colspan="2" align="center">
              <input type="submit" name="submit" value="submit">
              <input type="reset" name="reset" value="cancel">
            </td>
          </tr>
        </table>
      </body>
    </html>
