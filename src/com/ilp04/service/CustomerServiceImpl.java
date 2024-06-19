package com.ilp04.service;
 
import java.sql.Connection;
import java.util.ArrayList;

import com.ilp04.dao.CustomerDAO;
import com.ilp04.entity.Customer;
 
public class CustomerServiceImpl implements CustomerService {
    private CustomerDAO customerDAO = new CustomerDAO();
 
    @Override
    public ArrayList<Customer> getAllCustomers() {
        Connection connection = customerDAO.getConnection();
        ArrayList<Customer> customerList = customerDAO.getAllCustomers(connection);
        customerDAO.closeConnection(connection);
        return customerList;
    }
 
    @Override
    public int insertCustomer(Customer customer) {
        Connection connection = customerDAO.getConnection();
        int result = customerDAO.insertCustomer(connection, customer);
        customerDAO.closeConnection(connection);
        return result;
    }
 
    @Override
    public int updateCustomer(Customer customer) {
        Connection connection = customerDAO.getConnection();
        int result = customerDAO.updateCustomer(connection, customer);
        customerDAO.closeConnection(connection);
        return result;
    }
 
    @Override
    public Customer getCustomerByCode(int customerCode) {
        Connection connection = customerDAO.getConnection();
        Customer customer = customerDAO.getCustomerByCode(connection, customerCode);
        customerDAO.closeConnection(connection);
        return customer;
    }
}