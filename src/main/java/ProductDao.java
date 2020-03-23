import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class ProductDao {
    private static final String SELECT_FROM_PRODUCT = "SELECT * FROM product";
    private static final String INSERT_INTO_PRODUCT=
            "INSERT INTO product (product_name, product_description, price) VALUES (?, ?, ?)";
    private static final String DELETE_FROM_PRODUCT = "DELETE FROM product WHERE product_name = ?";
    private static Connection connection;

    private static Logger log = Logger.getLogger(ProductDao.class);

    public ProductDao(){
        PropertyConfigurator.configure("log4j.properties");
        try {
            connection = ConnectionUtil.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void insert(String product_name, String product_description, double price) throws SQLException {
        log.info("Try to create new product");
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_PRODUCT);
        preparedStatement.setString(1, product_name);
        preparedStatement.setString(2, product_description);
        preparedStatement.setDouble(3, price);

        preparedStatement.executeUpdate();
        log.info("Created new product");
    }

    public static List<Product> getAll() throws SQLException {
        log.info("Try to get all products");
        ResultSet resultSet = connection.createStatement().executeQuery(SELECT_FROM_PRODUCT);

        List<Product> products = new ArrayList<>();

        while (resultSet.next()){
            products.add(Product.of(resultSet));
        }
        return products;
    }

    public static Product getProduct(String product_name) throws SQLException {
        log.info("Try to get product");
        Product product = null;
        List<Product> products = getAll();
        for (Product p: products) {
            if (p.product_name.equals(product_name)){
                product = p;
            }
        };
        return product;
    }

    public static void delete(String product_name) throws SQLException {
        log.info("Try to delete product");
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_FROM_PRODUCT);
        preparedStatement.setString(1, product_name);

        preparedStatement.executeUpdate();
    }

}
