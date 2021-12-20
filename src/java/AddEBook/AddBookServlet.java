/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddEBook;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nsivaakumaar
 */
@WebServlet("/AddBookServlet")
public class AddBookServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            AddBookBean ob = new AddBookBean();
            ob.setisbn_number(request.getParameter("ISBN_Number"));
            ob.setauthor_first_name(request.getParameter("Author_First_Name"));
            ob.setauthor_last_name(request.getParameter("Author_Last_Name"));
            ob.setfile_path(request.getParameter("location"));
            ob.setbook_name(request.getParameter("Book_Name"));
            if(AddBook.insert(ob)){
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet StoreFileServerlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>file stored successfully "+"</h1>");
            out.println("</body>");
            out.println("</html>");
            }
            else{
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet StoreFileServerlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>file not stored successfully "+"</h1>");
            out.println("</body>");
            out.println("</html>");
            }
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
