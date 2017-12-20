<%@ page contentType="text/html;charset=GBK"%>
<html>
  <body>
    <h1>response redirect</h1>
    <form action="response_redirect.jsp">
      <table border="1">
        <tr>
          <td>
            <select name="pg">
              <option value="0">This Page</option>
              <option value="1">hello page</option>
              <option value="2">person_info page</option>
            </select>
          </td>
        </tr>
        <tr>
          <td>
            <input type="submit" value="submit">
          </td>
        </tr>
      </table>
    </form>
    <%
        String pg = request.getParameter("pg");
        if ("1".equals(pg)) {
          response.sendRedirect("hello.jsp");
        }else if ("2".equals(pg)) {
          response.sendRedirect("person_info.jsp");
        }else{
          out.println("Still in this page");
        }
      %>
    </body>
  </html>
