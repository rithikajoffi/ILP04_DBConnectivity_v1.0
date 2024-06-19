package com.ilp04.utility;
 
import java.util.ArrayList;
import java.util.Scanner;
 
import com.ilp04.entity.Customer;
import com.ilp04.service.CustomerService;
import com.ilp04.service.CustomerServiceImpl;
 
public class CustomerUtility {
    private static CustomerService customerService = new CustomerServiceImpl();
    private static Scanner scanner = new Scanner(System.in);
 
    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("Choose an option:");
            System.out.println("1. Display all customers");
            System.out.println("2. Update customer details");
            System.out.println("3. Insert new customer");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
 
            switch (choice) {
                case 1:
                    displayAllCustomers();
                    break;
                case 2:
                    updateCustomerDetails();
                    break;
                case 3:
                    insertNewCustomer();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close(); // Close scanner when done
    }
 
    private static void displayAllCustomers() {
        ArrayList<Customer> customerList = customerService.getAllCustomers();
        for (Customer customer : customerList) {
            System.out.println("Customer code: " + customer.getCustomerCode());
            System.out.println("Customer first name: " + customer.getCustomerFirstName());
            System.out.println("Customer last name: " + customer.getCustomerLastName());
            System.out.println("Address: " + customer.getAddress());
            System.out.println("Phone number: " + customer.getPhoneNumber());
            System.out.println("Adhar number: " + customer.getAdharNumber());
            System.out.println();
        }
    }
 
    private static void updateCustomerDetails() {
        System.out.println("Enter customer code to update:");
        int customerCode = scanner.nextInt();
        scanner.nextLine(); // Consume newline
 
        Customer existingCustomer = customerService.getCustomerByCode(customerCode);
        if (existingCustomer == null) {
            System.out.println("Customer not found.");
            return;
        }
 
        System.out.println("Enter new first name:");
        String newFirstName = scanner.nextLine();
        existingCustomer.setCustomerFirstName(newFirstName);
 
        System.out.println("Enter new last name:");
        String newLastName = scanner.nextLine();
        existingCustomer.setCustomerLastName(newLastName);
 
        System.out.println("Enter new address:");
        String newAddress = scanner.nextLine();
        existingCustomer.setAddress(newAddress);
 
        System.out.println("Enter new phone number:");
        long newPhoneNumber = scanner.nextLong();
        existingCustomer.setPhoneNumber(newPhoneNumber);
 
        System.out.println("Enter new Aadhar number:");
        long newAdharNumber = scanner.nextLong();
        existingCustomer.setAdharNumber(newAdharNumber);
 
        int rowsAffected = customerService.updateCustomer(existingCustomer);
        if (rowsAffected > 0) {
            System.out.println("Customer details updated successfully.");
        } else {
            System.out.println("Failed to update customer details.");
        }
    }
 
    private static void insertNewCustomer() {
        System.out.println("Enter customer code:");
        int customerCode = scanner.nextInt();
        scanner.nextLine(); // Consume newline
 
        System.out.println("Enter customer first name:");
        String customerFirstName = scanner.nextLine();
 
        System.out.println("Enter customer last name:");
        String customerLastName = scanner.nextLine();
 
        System.out.println("Enter address:");
        String address = scanner.nextLine();
 
        System.out.println("Enter phone number:");
        long phoneNumber = scanner.nextLong();
 
        System.out.println("Enter Aadhar number:");
        long adharNumber = scanner.nextLong();
 
        Customer newCustomer = new Customer(customerCode, customerFirstName, customerLastName, address, phoneNumber, adharNumber);
 
        int rowsAffected = customerService.insertCustomer(newCustomer);
        if (rowsAffected > 0) {
            System.out.println("New customer inserted successfully.");
        } else {
            System.out.println("Failed to insert new customer.");
        }
    }
}
 