package Logos.daos;

import Logos.ConnectionUtil;
import Logos.entities.Basket;
import Logos.entities.Product;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BasketDao {
    private static final String SELECT_FROM_BASKET = "SELECT * FROM basket";
    private static final String SELECT_FROM_BASKET_WHERE_USERID = "SELECT * FROM basket where user_id = ?";
    private static final String INSERT_INTO_BASKET =
            "INSERT INTO basket (user_id, product_id) VALUES (?, ?)";
    private static final String DELETE_FROM_BASKET = "DELETE FROM basket WHERE product_id = ? and user_id = ?";
    private static Connection connection;

    private static Logger log = Logger.getLogger(BasketDao.class);

    public BasketDao() {
        PropertyConfigurator.configure("log4j.properties");
        try {
            connection = ConnectionUtil.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void insert(int user_id, int product_id) throws SQLException {
        log.info("Try to put new product into user basket");
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_BASKET);
        preparedStatement.setInt(1, user_id);
        preparedStatement.setInt(2, product_id);

        preparedStatement.executeUpdate();
        log.info("Added new product into basket");
    }

    public static List<Product> getProducts(int user_id) throws SQLException {
        log.info("Try to get user products from basket");
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FROM_BASKET_WHERE_USERID);
        preparedStatement.setInt(1, user_id);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Product> products = new ArrayList<>();

        List<Product> allProducts = ProductDao.getAll();


        while (resultSet.next()) {
            for (Product p: allProducts) {
                if (p.getId() == Basket.of(resultSet).getProduct_id()){
                    products.add(p);
                }
            }
        }
        return products;
    }

    public static void delete(int user_id, int product_id) throws SQLException {
        log.info("Try to delete product from basket");
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_FROM_BASKET);
        preparedStatement.setInt(1, user_id);
        preparedStatement.setInt(2, product_id);

        preparedStatement.executeUpdate();
    }
}