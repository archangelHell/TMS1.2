package by.Hellena.BB;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
public class loginSrvlet extends HttpServlet {
    private Map<String, String> users;

    @Override
    public void init()  {
        users = new HashMap<>();
        users.put("admin", "password");
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("Username: ");
        String password = req.getParameter("Password: ");

        if (users.containsKey(username) && users.get(username).equals(password)) {
            req.getSession().setAttribute("username", username);
            resp.sendRedirect("/account");
        } else {
            resp.sendRedirect("/login");
        }
    }
}
