
/*6b. Build a servlet program to create a cookie to get your name through text box and press
submit button to display the message by greeting Welcome back your name ! , you have
visited this page n times ( n = number of your visit ) and demonstrate the expiry of cookie
also.
*/
package com.servlet;
//Step 1: Required imports
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

//Step 2: Create servlet class and use WebServlet annotation
@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
 private static final long serialVersionUID = 1L;
 
 // Note: In a real-world multi-user app, this count should be stored in a database or session,
 // as instance variables in Servlets are shared across all users.
 int count = 0; 

 // Step 3: Handle GET requests
 public void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
     
     response.setContentType("text/html");
     PrintWriter out = response.getWriter();

     // Step 4: Create or retrieve cookies from parameters
     String userName = request.getParameter("userName");
     
     if (userName != null && !userName.isEmpty()) {
         // Create a new cookie
         Cookie userCookie = new Cookie("user", userName);
         
         // Step 5: Set cookie properties
         // Note: 30 seconds (per your comment logic, though 60 is 1 minute)
         userCookie.setMaxAge(30); 
         
         // Step 6: Add cookie to response
         response.addCookie(userCookie);
     }

     // Step 7: Read existing cookies from the browser request
     Cookie[] cookies = request.getCookies();
     String existingUser = null;

     if (cookies != null) {
         for (Cookie cookie : cookies) {
             if (cookie.getName().equals("user")) {
                 existingUser = cookie.getValue();
                 break;
             }
         }
     }

     // Step 8: Generate HTML response
     out.println("<html>");
     out.println("<head><title>Cookie Example</title></head>");
     out.println("<body>");

     if (existingUser != null) {
         count += 1;
         out.println("<font color='blue'><h2>Welcome back, " + existingUser + "!</h2></font>");
         out.println("<font color='magenta'><h2>You have visited this page " + count + " times!</h2></font>");
         
         // Logout Button (Triggers doPost)
         out.println("<form action='CookieServlet' method='post'>");
         out.println("<input type='submit' value='Logout'>");
         out.println("</form>");
     } else {
         out.println("<h2 style='color:red;'>Welcome Guest! You have been logged out or are visiting for the first time.</h2>");
         out.println("<form action='CookieServlet' method='get'>");
         out.println("Enter your name: <input type='text' name='userName'>");
         out.println("<input type='submit' value='Submit'>");
         out.println("</form>");
     }
     
     out.println("</body></html>");
 }

 // Step 10: Handle POST requests (used here for logout)
 public void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
     
     // Correct Logout Logic: Create a cookie with the same name and set MaxAge to 0
     Cookie cookie = new Cookie("user", "");
     cookie.setMaxAge(0); 
     
     // Add the expired cookie to the response to tell the browser to delete it
     response.addCookie(cookie);
     
     // Redirect back to the servlet to show the Guest screen
     response.sendRedirect("CookieServlet");
 }
}