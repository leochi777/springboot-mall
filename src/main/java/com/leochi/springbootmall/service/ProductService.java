package com.leochi.springbootmall.service;

import com.leochi.springbootmall.model.Product;
import org.springframework.stereotype.Service;


public interface ProductService {
    Product getProductById(Integer productId);

}
