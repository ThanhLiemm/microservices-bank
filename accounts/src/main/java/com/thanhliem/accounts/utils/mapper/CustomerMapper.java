package com.thanhliem.accounts.utils.mapper;

import com.thanhliem.accounts.dto.CustomerDto;
import com.thanhliem.accounts.entity.Customer;

public class CustomerMapper {
    public static CustomerDto mapToCustomerDto(Customer customer, CustomerDto customerDto) {
        customerDto.setName(customer.getName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setMobileNumber(customer.getMobileNumber());
        return customerDto;
    }

    public static CustomerDto mapToCustomerDto(Customer customer) {
        return mapToCustomerDto(customer, new CustomerDto());
    }

    public static Customer mapToCustomer(CustomerDto customerDto, Customer customer) {
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setMobileNumber(customerDto.getMobileNumber());
        return customer;
    }

    public static Customer mapToCustomer(CustomerDto customerDto) {
        return mapToCustomer(customerDto, new Customer());
    }
}
