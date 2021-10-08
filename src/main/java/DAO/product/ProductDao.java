package DAO.product;

import DAO.DBConnection;
import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements IProductDao {
    private Connection connection = DBConnection.getConnection();

    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("select * from product");
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String price = resultSet.getString("price");
                String quantity = resultSet.getString("quantity");
                String color = resultSet.getString("color");
                String note = resultSet.getString("note");
                String category = resultSet.getString("category");
                Product product = new Product(id,name,price,quantity,color,note,category);
                products.add(product);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public boolean save(Product product) {
        boolean isCreated = false;
        try {
            PreparedStatement statement = connection.prepareStatement("insert into product (name, price, quantity, color,note,category) value (?,?,?,?,?,?)");
            statement.setString(1,product.getName());
            statement.setString(2,product.getPrice());
            statement.setString(3,product.getQuantity());
            statement.setString(4,product.getColor());
            statement.setString(5,product.getNote());
            statement.setString(6,product.getCategory());
            isCreated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isCreated;
    }

    @Override
    public boolean update(int id, Product product) {
        boolean isUpdated = false;
        try {
            PreparedStatement statement = connection.prepareStatement("update product set name = ?, price = ?, quantity = ?, color = ?,note = ?,category = ? where id = ?");
            statement.setString(1, product.getName());
            statement.setString(2, product.getPrice());
            statement.setString(3, product.getQuantity());
            statement.setString(4, product.getColor());
            statement.setString(5, product.getNote());
            statement.setString(6, product.getCategory());
            statement.setInt(7, product.getId());
            isUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isUpdated;
    }

    @Override
    public boolean delete(int id) {
        boolean isDeleted = false;
        try {
            PreparedStatement statement = connection.prepareStatement("delete from product where id = ?");
            statement.setInt(1, id);
            isDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isDeleted;
    }

    @Override
    public Product findById(int id) {
        Product product = new Product();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from product where id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String price = resultSet.getString("price");
                String quantity = resultSet.getString("quantity");
                String color = resultSet.getString("color");
                String note = resultSet.getString("note");
                String category = resultSet.getString("category");

                product = new Product(id, name, price, quantity, color, note, category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public List<Product> findProductByName(String name) {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from product where name like ?");
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name1 = resultSet.getString("name");
                String price = resultSet.getString("price");
                String quantity = resultSet.getString("quantity");
                String color = resultSet.getString("color");
                String note = resultSet.getString("note");
                String category = resultSet.getString("category");


                Product product = new Product(id, name1, price, quantity, color,note,category);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}
