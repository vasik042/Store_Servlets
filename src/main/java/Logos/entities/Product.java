package Logos.entities;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Product {
    String product_name;
    String product_description;
    double price;
    int id;

    Product(String product_name, double price){
        this.price = price;
        this.product_name = product_name;
    }
    public Product(String product_description, String product_name, double price){
        this.product_description = product_description;
        this.price = price;
        this.product_name = product_name;
    }

    public static Product of(ResultSet resultSet) throws SQLException {
        Product product = new Product(resultSet.getString("product_name"), resultSet.getString("product_description"), resultSet.getDouble("price"));
        product.setId(resultSet.getInt("id"));
        return product;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
