package by.Hellena.BB;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;

@WebServlet(value = "/user")
class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String gender = request.getParameter("gender");
        String date = request.getParameter("date");
        String phoneNumber = request.getParameter("phoneNumber");

        if (!validateUserData(username, password, firstName, lastName, date, phoneNumber)) {
            request.setAttribute("errorMessage", "Проверьте введенные данные");

            request.setAttribute("username", username);
            request.setAttribute("firstName", firstName);
            request.setAttribute("lastName", lastName);
            request.setAttribute("gender", gender);
            request.setAttribute("date", date);
            request.setAttribute("phoneNumber", phoneNumber);
            request.getRequestDispatcher("create-user.jsp").forward(request, response);
        } else
        {
            request.setAttribute("username", username);
            request.setAttribute("firstName", firstName);
            request.setAttribute("lastName", lastName);
            request.setAttribute("gender", gender);
            request.setAttribute("date", date);
            request.setAttribute("phoneNumber", phoneNumber);
            request.getRequestDispatcher("/success.jsp").forward(request, response);
        }
    }
    private boolean validateUserData(String username, String password, String firstName, String lastName, String date, String phoneNumber) {
        LocalDate dobDate;
        try {
            dobDate = LocalDate.parse(date);
        } catch (DateTimeParseException e) {
            return false;
        }
        LocalDate currentDate = LocalDate.now();
        int age = Period.between(dobDate, currentDate).getYears();

        if (age < 18) {
            return false;
        }
        String phoneNumberDigitsOnly = phoneNumber.replaceAll("\\D", "");
        return phoneNumberDigitsOnly.length() == 12;
    }
}
