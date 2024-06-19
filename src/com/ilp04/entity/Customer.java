package com.ilp04.entity;
 
public class Customer {
    private int customerCode;
    private String customerFirstName;
    private String customerLastName;
    private String address;
    private long phoneNumber; // Updated variable name
    private long adharNumber; // Updated variable name
 
    public Customer(int customerCode, String customerFirstName, String customerLastName, String address, long phoneNumber, long adharNumber) {
        this.customerCode = customerCode;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.adharNumber = adharNumber;
    }
 
    // Getters and setters
    // Make sure the methods match the updated variable names
 
    public int getCustomerCode() {
        return customerCode;
    }
 
    public void setCustomerCode(int customerCode) {
        this.customerCode = customerCode;
    }
 
    public String getCustomerFirstName() {
        return customerFirstName;
    }
 
    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }
 
    public String getCustomerLastName() {
        return customerLastName;
    }
 
    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }
 
    public String getAddress() {
        return address;
    }
 
    public void setAddress(String address) {
        this.address = address;
    }
 
    public long getPhoneNumber() {
        return phoneNumber;
    }
 
    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
 
    public long getAdharNumber() {
        return adharNumber;
    }
 
    public void setAdharNumber(long adharNumber) {
        this.adharNumber = adharNumber;
    }
}