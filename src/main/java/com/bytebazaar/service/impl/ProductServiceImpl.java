package com.bytebazaar.service.impl;

import com.bytebazaar.mapper.ProductMapper;
import com.bytebazaar.models.Product;
import com.bytebazaar.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;

    @Override
    public List<Product> findAll() {
        return productMapper.findAll();
    }

    @Override
    public Product findById(int id) {
        return productMapper.findById(id);
    }

    @Override
    public int deleteById(int id) {
        return productMapper.deleteById(id);
    }

    @Override
    public int save(Product product) {
        return productMapper.save(product);
    }

    @Override
    public int update(int id, Product product) {
        product.setId(id);
        return productMapper.update(product);
    }

    @Override
    public boolean isProductDeletable(int id) {
        return productMapper.isProductDeletable(id)<1;
    }

    @Override
    public int quantityOfProducts(List<Product> products) {
        return products.stream()
                .mapToInt(Product::getStock)
                .sum();
    }

    @Override
    public Product aboutToSellOut(List<Product> products) {
        Optional<Product> productOptional = products.stream()
                .filter(product -> product.getStock() < 10)
                .min(Comparator.comparingInt(Product::getStock));

        return productOptional.orElse(null);
    }

    @Override
    public Product mostExpensiveProduct(List<Product> products) {
        return products.stream()
                .max(Comparator.comparingDouble(Product::getPrice))
                .orElseThrow(() -> new NoSuchElementException("No products found"));
    }

    @Override
    public List<Product> matchesQuery(List<Product> products, String query) {
        if(query != null && !query.isEmpty()){
            products = products.stream()
                    .filter(product -> product.matchesQuery(query.toLowerCase()))
                    .collect(Collectors.toList());
        }
        return products;
    }

}
