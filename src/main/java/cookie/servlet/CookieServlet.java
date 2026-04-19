package cookie.servlet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("username");

        int visitCount = 1;

        Cookie[] cookies = request.getCookies();

        Cookie nameCookie = null;
        Cookie visitCookie = null;

        // Read existing cookies
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("userName")) {
                    nameCookie = c;
                }
                if (c.getName().equals("visitCount")) {
                    visitCookie = c;
                }
            }
        }

        // Increase visit count if cookie exists
        if (visitCookie != null) {
            visitCount = Integer.parseInt(visitCookie.getValue());
            visitCount++;
        }

        // Create cookies
        Cookie c1 = new Cookie("userName", name);
        Cookie c2 = new Cookie("visitCount", String.valueOf(visitCount));

        // ⏳ Cookie expiry (30 seconds demo)
        c1.setMaxAge(30);
        c2.setMaxAge(30);

        response.addCookie(c1);
        response.addCookie(c2);

        // Output page
        out.println("<html><body>");

        out.println("<h2>Welcome back " + name + "!</h2>");
        out.println("<h3>You have visited this page " + visitCount + " times</h3>");

        out.println("<h3>All Cookies:</h3>");

        if (cookies != null) {
            for (Cookie c : cookies) {
                out.println(c.getName() + " = " + c.getValue() + "<br>");
            }
        } else {
            out.println("No cookies found");
        }

        out.println("<br><b>Note:</b> Cookies expire in 30 seconds (demo purpose)");

        out.println("</body></html>");
    }
}