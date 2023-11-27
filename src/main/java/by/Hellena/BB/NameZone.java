package by.Hellena.BB;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
@WebServlet(urlPatterns = "/name")
public class NameZone extends HttpServlet {
    private Set<String> names;
    public void init() {
        names = new HashSet<>();
        names.add("John");
        names.add("Jane");
        names.add("Alice");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/plain");
        response.getWriter().write(names.toString());
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getPathInfo().substring(1);

        if (names.contains(name)) {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
            response.getWriter().write("Name already exists");
        } else {
            names.add(name);
            response.setStatus(HttpServletResponse.SC_CREATED);
        }
    }
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getPathInfo().substring(1);

        if (names.contains(name)) {
            names.remove(name);
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.getWriter().write("Name not found");
        }
    }
}