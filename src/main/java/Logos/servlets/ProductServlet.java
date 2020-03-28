package Logos.servlets;

import Logos.daos.ProductDao;
import Logos.entities.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/products")
public class ProductServlet extends HttpServlet {

    private ProductDao productDao = new ProductDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productId = request.getParameter("id");
        Product product = null;
        try {
            product = productDao.getProductByID(Integer.parseInt(productId));
            request.setAttribute("productName", product.getProduct_name());
            request.setAttribute("productD", product.getProduct_description());
            request.setAttribute("productP", product.getPrice());
            request.setAttribute("productId", product.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("singleProduct.jsp").forward(request, response);
    }

    // to update resource (product)
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        super.doPut(req, resp);
    }

    // to delete resource (product)
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        super.doDelete(req, resp);
    }

}
