package by.Hellena.BB;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
@WebServlet(urlPatterns = "/time")
public class TimeZone extends HttpServlet  { protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        String zone = req.getParameter("zone");
        ZoneId zoneId;
        if (zone != null && !zone.isEmpty()) {
            zoneId = ZoneId.of(zone);
        } else {
            zoneId = ZoneId.systemDefault();
        }
        LocalTime currentTime = LocalTime.now(zoneId);
        String formattedTime = currentTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        resp.setContentType("text/plain");
        resp.getWriter().write(formattedTime);
    }
}

