import java.io.IOException;  
import java.io.PrintWriter;  
import java.sql.*;  
  
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;


public class Home extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException 
    {  
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
        out.println("<link href='style.css'>");
        out.println("<h1>Welcome Employee</h1>");
        out.println("<a href='./slots.html'><h3>Checkout Slots</h3></a>");
        out.println("<a href='./messages.jsp'><h3>Checkout Messages</h3></a>");
    }  
}