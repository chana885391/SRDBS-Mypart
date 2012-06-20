package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.awt.Checkbox;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.io.*;

public final class ConnectJspToMysql_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\r\n");
      out.write("\"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("\r\n");
      out.write(" \r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>display data from the table using jsp</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<h2>Data from the table 'FULL_FILE' of database 'student'</h2>\r\n");

try {
/* Create string of connection url within specified format with machine
name, port number and database name. Here machine name id localhost and 
database name is student. */
String connectionURL = "jdbc:mysql://localhost:3306/SRDBSDB";
// declare a connection by using Connection interface
Connection connection = null;
/* declare object of Statement interface that is used for executing sql 
statements. */
Statement statement = null;
// declare a resultset that uses as a table for output data from tha table.
ResultSet rs = null;
// Load JBBC driver "com.mysql.jdbc.Driver"
Class.forName("com.mysql.jdbc.Driver").newInstance();
/* Create a connection by using getConnection() method that takes parameters 
of string type connection url, user name and password to connect to database.*/
connection = DriverManager.getConnection(connectionURL, "SRDBS", "terminator");
/* createStatement() is used for create statement object that is used for 
sending sql statements to the specified database. */
statement = connection.createStatement();
// sql query to retrieve values from the secified table.
String QueryString = "SELECT * from Full_File";
rs = statement.executeQuery(QueryString);

      out.write("\r\n");
      out.write("<TABLE cellpadding=\"15\" border=\"1\" style=\"background-color: #ffffcc;\">\r\n");
      out.write("<FORM ACTION=\"ConnectJspToMysql.jsp\" method=\"get\" >    \r\n");

while (rs.next()) {

      out.write("\r\n");
      out.write("<TR>\r\n");
      out.write("<TD><input type=\"checkbox\" name=\"id\" value=");
      out.print(rs.getLong(1));
      out.write(" ></TD>    \r\n");
      out.write("<TD>");
      out.print(rs.getLong(1));
      out.write("</TD>\r\n");
      out.write("<TD>");
      out.print(rs.getString(2));
      out.write("</TD>\r\n");
      out.write("<TD>");
      out.print(rs.getString(3));
      out.write("</TD>\r\n");
      out.write("<TD>");
      out.print(rs.getString(4));
      out.write("</TD>\r\n");
      out.write("<TD>");
      out.print(rs.getString(5));
      out.write("</TD>\r\n");
      out.write("</TR>\r\n");
 } 
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("    <td>\r\n");
      out.write("        <input type=\"submit\" value=\"Submit\" onclick=\"\" />\r\n");
      out.write("    </td>\r\n");
      out.write("</tr>\r\n");
      out.write("</form>\r\n");
      out.write("</TABLE>\r\n");
      out.write("\r\n");

// close all the connections.
rs.close();
statement.close();
connection.close();
} catch (Exception ex) {

      out.write("\r\n");
      out.write("\r\n");
      out.write("</font>\r\n");
      out.write("<font size=\"+3\" color=\"red\"></b>\r\n");

out.println("Unable to connect to database.");
}

String select[] = request.getParameterValues("id"); 
if (select != null && select.length != 0) {
out.println("You have selected: ");
for (int i = 0; i < select.length; i++) {
out.println(select[i]); 
}
}

      out.write("\r\n");
      out.write("\r\n");
      out.write("<TABLE>\r\n");
      out.write("<TR>\r\n");
      out.write("\r\n");
      out.write("<TD>\r\n");
      out.write("        </TD>\r\n");
      out.write("        <TD><FORM ACTION=\"welcome_to_database_query.jsp\" method=\"get\" >\r\n");
      out.write("        <button type=\"submit\"><-- back</button></form></TD>\r\n");
      out.write("</TR>\r\n");
      out.write("</TABLE>\r\n");
      out.write("</font>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
