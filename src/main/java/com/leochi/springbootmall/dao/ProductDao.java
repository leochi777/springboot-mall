package com.leochi.springbootmall.dao;

import com.leochi.springbootmall.dto.ProductQueryParams;
import com.leochi.springbootmall.dto.ProductRequest;
import com.leochi.springbootmall.model.Product;

import java.util.List;

public interface ProductDao {
    Product getProductById(Integer productId);

    List<Product> getProducts(ProductQueryParams productQueryParams);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProduct(Integer productId);

    Integer countProduct(ProductQueryParams productQueryParams);


}
