package by.Hellena.BB;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class account extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = (String) request.getSession().getAttribute("username");

        if (username != null) {
            response.setContentType("text/html");
            response.getWriter().write("<h2>Welcome home, " + username + "! To Ur acc. </h2>");
        } else {
            response.sendRedirect("/login");
        }
    }
}
