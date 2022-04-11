package com.leochi.springbootmall.dao;

import com.leochi.springbootmall.constant.ProductCategory;
import com.leochi.springbootmall.dto.ProductRequest;
import com.leochi.springbootmall.model.Product;

import java.util.List;

public interface ProductDao {
    Product getProductById(Integer productId);

    List<Product> getProducts(ProductCategory category,String search);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProduct(Integer productId);

}
