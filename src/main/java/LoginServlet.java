import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = null;
        try {
            user = userDao.getUser(email, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (user != null) {
            request.getRequestDispatcher("cabinet.jsp").forward(request, response);
        }else   {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}