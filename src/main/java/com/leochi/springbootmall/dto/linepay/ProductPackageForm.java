package com.leochi.springbootmall.dto.linepay;

import com.leochi.springbootmall.model.Product;

import java.math.BigDecimal;
import java.util.List;

public class ProductPackageForm {
    private String id;
    private BigDecimal amount;
    private List<ProductForm> products;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public List<ProductForm> getProducts() {
        return products;
    }

    public void setProducts(List<ProductForm> products) {
        this.products = products;
    }
}
