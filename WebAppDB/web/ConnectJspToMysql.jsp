<%@page import="java.awt.Checkbox"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %> 
<html>
<head>
<title>display data from the table using jsp</title>
</head>
<body>
<h2>Data from the table 'FULL_FILE' of database 'student'</h2>
<%
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
%>
<TABLE cellpadding="15" border="1" style="background-color: #ffffcc;">
<FORM ACTION="ConnectJspToMysql.jsp" method="get" >    
<%
while (rs.next()) {
%>
<TR>
<TD><input type="checkbox" name="id" value=<%=rs.getLong(1)%> ></TD>    
<TD><%=rs.getLong(1)%></TD>
<TD><%=rs.getString(2)%></TD>
<TD><%=rs.getString(3)%></TD>
<TD><%=rs.getString(4)%></TD>
<TD><%=rs.getString(5)%></TD>
</TR>
<% } %>
<tr>
    <td>
        <input type="submit" value="Submit" onclick="" />
    </td>
</tr>
</form>
</TABLE>

<%
// close all the connections.
rs.close();
statement.close();
connection.close();
} catch (Exception ex) {
%>

</font>
<font size="+3" color="red"></b>
<%
out.println("Unable to connect to database.");
}

String select[] = request.getParameterValues("id"); 
if (select != null && select.length != 0) {
out.println("You have selected: ");
for (int i = 0; i < select.length; i++) {
out.println(select[i]); 
}
}
%>

<TABLE>
<TR>

<TD>
        </TD>
        <TD><FORM ACTION="welcome_to_database_query.jsp" method="get" >
        <button type="submit"><-- back</button></form></TD>
</TR>
</TABLE>
</font>
</body>
</html>