package com.example.ung_dung_quan_ly_kh.service;

import com.example.ung_dung_quan_ly_kh.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(int id);

    void update(int id, Customer customer);

    void remove(int id);
}