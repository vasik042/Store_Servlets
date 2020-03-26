package Logos.entities;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Basket {
    int id;
    int product_id;
    int user_id;

    Basket(int user_id, int product_id){
        this.product_id = product_id;
        this.user_id = user_id;
    }


    public static Basket of(ResultSet resultSet) throws SQLException {
        Basket basket = new Basket(resultSet.getInt("user_id"), resultSet.getInt("product_id"));
        basket.setId(resultSet.getInt("id"));
        return basket;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}

