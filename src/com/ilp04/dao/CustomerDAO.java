package com.ilp04.dao;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
 
import com.ilp04.entity.Customer;
 
public class CustomerDAO {
    // get connection
    public Connection getConnection() {
        String connectionURL = "jdbc:mysql://localhost:3306/bankdb?useSSL=false";
        String userName = "root";
        String password = "experion@123";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionURL, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
 
    // close connection
    public void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    public ArrayList<Customer> getAllCustomers(Connection connection) {
        ArrayList<Customer> customerList = new ArrayList<Customer>();
        Statement statement;
        ResultSet resultSet;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM customer");
            while (resultSet.next()) {
                int customerCode = resultSet.getInt("customer_code");
                String customerFirstName = resultSet.getString("customer_firstname");
                String customerLastName = resultSet.getString("customer_lastname");
                String address = resultSet.getString("address");
                long phoneNumber = resultSet.getLong("phonenumber");
                long adharNumber = resultSet.getLong("adhar_no");
                Customer customer = new Customer(customerCode, customerFirstName, customerLastName, address, phoneNumber, adharNumber);
                customerList.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }
 
    public Customer getCustomerByCode(Connection connection, int customerCode) {
        Customer customer = null;
        String query = "SELECT * FROM customer WHERE customer_code = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, customerCode);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String customerFirstName = resultSet.getString("customer_firstname");
                String customerLastName = resultSet.getString("customer_lastname");
                String address = resultSet.getString("address");
                long phoneNumber = resultSet.getLong("phonenumber");
                long adharNumber = resultSet.getLong("adhar_no");
                customer = new Customer(customerCode, customerFirstName, customerLastName, address, phoneNumber, adharNumber);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }
 
    public int insertCustomer(Connection connection, Customer customer) {
        String query = "INSERT INTO customer (customer_code, customer_firstname, customer_lastname, address, phonenumber, adhar_no) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, customer.getCustomerCode());
            preparedStatement.setString(2, customer.getCustomerFirstName());
            preparedStatement.setString(3, customer.getCustomerLastName());
            preparedStatement.setString(4, customer.getAddress());
            preparedStatement.setLong(5, customer.getPhoneNumber());
            preparedStatement.setLong(6, customer.getAdharNumber());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
 
    public int updateCustomer(Connection connection, Customer customer) {
        String query = "UPDATE customer SET customer_firstname = ?, customer_lastname = ?, address = ?, phonenumber = ?, adharno = ? WHERE customer_code = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, customer.getCustomerFirstName());
            preparedStatement.setString(2, customer.getCustomerLastName());
            preparedStatement.setString(3, customer.getAddress());
            preparedStatement.setLong(4, customer.getPhoneNumber());
            preparedStatement.setLong(5, customer.getAdharNumber());
            preparedStatement.setInt(6, customer.getCustomerCode());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
 