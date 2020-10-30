import java.io.IOException;  
import java.io.PrintWriter;  
import java.sql.*;  
  
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;


public class Login extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException 
    {  
  
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
          
    String u=request.getParameter("email");  
    String p=request.getParameter("password");
    
    Connection con = null;
    Statement stm = null;
    ResultSet rs = null;

        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/blogdb","root", "");
            String query = "select * from trip where email='"+u+"' and password='"+p+"'";
            stm = con.createStatement();
            rs = stm.executeQuery(query);
            if (rs.next())
            {
                out.println("<h1>Welcome</h1>");
                out.println("<p>Name = "+rs.getString("name")+"</p>");
                out.println("<p>Email = "+rs.getString("email")+"</p>");
                out.println("<p>Address = "+rs.getString("address")+"</p>");
                out.println("<p>Zip Code = "+rs.getString("zip code")+"</p>");
                out.println("<p>Country = "+rs.getString("country")+"</p>");
                out.println("<p>Gender = "+rs.getString("gender")+"</p>");
                out.println("<p>Language = "+rs.getString("language")+"</p>");
            }
            else
            {
                out.println("<h1>Invalid Username and Password </h1>");
            }
        }
        catch(Exception e) 
        {
            out.print("Exception: " + e.getMessage());
        }
        finally 
        {
            try 
            {
                rs.close();
                stm.close();
                con.close();
            } 
            catch(SQLException e) {}
        }
    }  
}