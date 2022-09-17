package com.example.quan_ly_sp.service;

import com.example.quan_ly_sp.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    void save(Product product);

    void update(int id, Product product);

    void remove(int id);

    Product findById(int id);

    List<Product> searchNameProduct(String nameProduct);
}
