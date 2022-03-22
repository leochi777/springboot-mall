package com.leochi.springbootmall.dao;

import com.leochi.springbootmall.model.Product;

public interface ProductDao {
    Product getProductById(Integer productId);
}
