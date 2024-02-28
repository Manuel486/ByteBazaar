package com.bytebazaar.service;

import com.bytebazaar.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(int id);
    int deleteById(int id);
    int save(Product product);
    int update(int id,Product product);
    boolean isProductDeletable(int id);

    int quantityOfProducts(List<Product> products);
    Product aboutToSellOut(List<Product> products);
    Product mostExpensiveProduct(List<Product> products);
    List<Product> matchesQuery(List<Product> products, String query);
}
