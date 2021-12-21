<%-- 
    Document   : Search
    Created on : Dec 21, 2021, 7:57:58 AM
    Author     : nsivaakumaar
--%>

<%@ page import="java.sql.*" %>  
<%
    String book_name = request.getParameter("val");
    if (book_name == null || book_name.trim().equals("")) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "system", "oracle");
            PreparedStatement ps = con.prepareStatement("select \"isbn\",\"book\",\"fname\",\"lname\" from ebook");
            ResultSet rs = ps.executeQuery();

            if (!rs.isBeforeFirst()) {
                out.println("<p>No Book Found!</p>");
            } else {
                out.print("<table border='1' cellpadding='2' width='100%'>");
                out.print("<tr><th>ISBN Number</th><th>Book Name</th><th>Author First Name</th><th>Author Last Name</th></tr>");
                while (rs.next()) {
                    out.print("<tr><td>" + rs.getString(1) + "</td><td>" + rs.getString(2) + "</td><td>" + rs.getString(3) + "</td> <td>" + rs.getString(4) + "</td></tr>");
                }
                out.print("</table>");
            }//end of else for rs.isBeforeFirst  
            con.close();
        } catch (Exception e) {
            out.print(e);
        }
    } else {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "system", "oracle");
            PreparedStatement ps = con.prepareStatement("select \"isbn\",\"book\",\"fname\",\"lname\" from ebook where \"book\" like '" + book_name + "%'");
            ResultSet rs = ps.executeQuery();

            if (!rs.isBeforeFirst()) {
                out.println("<p>No Book Found!</p>");
            } else {
                out.print("<table border='1' cellpadding='2' width='100%'>");
                out.print("<tr><th>ISBN Number</th><th>Book Name</th><th>Author First Name</th><th>Author Last Name</th></tr>");
                while (rs.next()) {
                    out.print("<tr><td>" + rs.getString(1) + "</td><td>" + rs.getString(2) + "</td><td>" + rs.getString(3) + "</td> <td>" + rs.getString(4) + "</td></tr>");
                }
                out.print("</table>");
            }//end of else for rs.isBeforeFirst  
            con.close();
        } catch (Exception e) {
            out.print(e);
        }
    }//end of else  
%>  

