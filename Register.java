import java.io.IOException;  
import java.io.PrintWriter;  
import java.sql.*;  
  
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
  
public class Register extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
  
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
   // out.println("echo");      
    String n=request.getParameter("name");
    String u=request.getParameter("email");  
    String p=request.getParameter("psw");
    String a=request.getParameter("address");
    String z=request.getParameter("zipcode");
    String c=request.getParameter("country");
    String g=request.getParameter("gender");
    String l=request.getParameter("language");

    Connection con = null;
    try {
        Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance();
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/blogdb","root", "");
        PreparedStatement ps=con.prepareStatement("insert into trip values(?,?,?,?,?,?,?,?)");
        if (!con.isClosed())
            ps.setString(1,n);
            ps.setString(2,u);
            ps.setString(3,p);
            ps.setString(4,a);
            ps.setString(5,z);
            ps.setString(6,c);
            ps.setString(7,g);
            ps.setString(8,l);
            int i=ps.executeUpdate();
            response.sendRedirect("login.html");
    } catch(Exception e) {
        out.print("Exception: " + e.getMessage());
    } finally {
    try {
        if (con != null)
            con.close();
        } catch(SQLException e) {}
    }
      
        // RequestDispatcher rd=request.getRequestDispatcher("index.html");  
        // rd.include(request,response);  
    // }  
          
    out.close();  
    }  
}  