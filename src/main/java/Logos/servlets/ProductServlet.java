package Logos.servlets;

import Logos.daos.ProductDao;
import Logos.entities.Product;
import com.google.gson.Gson;

import javax.management.openmbean.CompositeData;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {

    private ProductDao productDao = new ProductDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        List<Product> products = null;
        try {
            products = productDao.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String json = new Gson().toJson(products);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String product_name = request.getParameter("product_name");
        String product_description = request.getParameter("description");
        String price = (request.getParameter("price"));

        Optional<String> errorMessage = getErrorMessage(price);
        if (errorMessage.isPresent()) {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write(errorMessage.get());

            return;
        }



        try {
            productDao.insert(product_name, product_description, Double.parseDouble(price));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("cabinet.jsp").forward(request, response);
    }

    private Optional<String> getErrorMessage(String price) {
        if (price.isEmpty()) {
            return Optional.of("Price can't be empty");
        }
        try {
            double parsedPrice = Double.parseDouble(price);
            return parsedPrice > 0 ? Optional.empty() : Optional.of("Price can't less then zero");
        } catch (NumberFormatException e) {
            return Optional.of("Price should be numeric");
        }
    }
}

