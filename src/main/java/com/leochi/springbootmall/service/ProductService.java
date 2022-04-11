package com.leochi.springbootmall.service;

import com.leochi.springbootmall.constant.ProductCategory;
import com.leochi.springbootmall.dto.ProductRequest;
import com.leochi.springbootmall.model.Product;

import java.util.List;


public interface ProductService {
    Product getProductById(Integer productId);

    List<Product> getProducts(ProductCategory category,String search);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProduct(Integer productId);
}
