/*9.a Build a Session Management using Servlet program set with one minute session to show Session
Tracking Information, Session ID,Session Creation Time,Last Access Time,Visit Count
*/
package javalab9;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.util.Date;

@WebServlet("/SessionTracker")
public class SessionTrackingServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get or create session
        HttpSession session = request.getSession(true);

        // Set session expiry time (1 minute)
        session.setMaxInactiveInterval(60);

        // Session details
        Date createTime = new Date(session.getCreationTime());
        Date lastAccessTime = new Date(session.getLastAccessedTime());
        String sessionId = session.getId();

        // Visit count logic
        Integer visitCount = (Integer) session.getAttribute("visitCount");

        if (visitCount == null) {
            visitCount = 1;
        } else {
            visitCount++;
        }

        session.setAttribute("visitCount", visitCount);

        // Response type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // HTML output
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>Session Tracking Demo</title></head>");
        out.println("<body>");

        out.println("<h2>Session Tracking Information</h2>");
        out.println("<p>Session ID: " + sessionId + "</p>");
        out.println("<p>Session Creation Time: " + createTime + "</p>");
        out.println("<p>Last Access Time: " + lastAccessTime + "</p>");
        out.println("<p>Visit Count: " + visitCount + "</p>");
        out.println("<p>Max Inactive Interval: " + session.getMaxInactiveInterval() + " seconds</p>");

        out.println("</body>");
        out.println("</html>");
    }
}