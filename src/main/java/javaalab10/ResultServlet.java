/*10.b Build an Application to get Rollno, Studentname, Sub1, Sub2, Sub3, Sub4 and Sub5
through JSP called index.jsp with client sided validation and submit to the servlet called
ResultServlet and process all the fields with server sided validation and display all the data
along with result ( Pass if all subjects greater than 40%) and Average marks through
result.jsp with a link to move to the client side
*/
package javaalab10;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

// This MUST match the 'action' in your index10b.jsp
@WebServlet("/ResultServlet") 
public class ResultServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            String rollNo = request.getParameter("rollNo");
            String name = request.getParameter("studentName");
            
            // Getting marks
            int s1 = Integer.parseInt(request.getParameter("sub1"));
            int s2 = Integer.parseInt(request.getParameter("sub2"));
            int s3 = Integer.parseInt(request.getParameter("sub3"));
            int s4 = Integer.parseInt(request.getParameter("sub4"));
            int s5 = Integer.parseInt(request.getParameter("sub5"));

            // Logic: Pass if all subjects > 40
            String result = (s1 >= 40 && s2 >= 40 && s3 >= 40 && s4 >= 40 && s5 >= 40) ? "Pass" : "Fail";
            double average = (s1 + s2 + s3 + s4 + s5) / 5.0;

            request.setAttribute("rollNo", rollNo);
            request.setAttribute("name", name);
            request.setAttribute("avg", average);
            request.setAttribute("result", result);

        } catch (Exception e) {
            request.setAttribute("error", "Invalid Input. Please enter numbers for marks.");
        }

        // Ensure result10b.jsp is in the same folder (usually webapp)
        request.getRequestDispatcher("result10b.jsp").forward(request, response);
    }
}