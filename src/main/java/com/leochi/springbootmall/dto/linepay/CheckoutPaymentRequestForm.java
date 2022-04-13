package com.leochi.springbootmall.dto.linepay;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class CheckoutPaymentRequestForm {
    @NotNull
    private BigDecimal amount;

    private String currency="TWD";

    private String orderId;

    @NotNull
    private ProductPackageForm productPackageForm;

    @NotNull
    private RedirectUrls redirectUrls;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public ProductPackageForm getProductPackageForm() {
        return productPackageForm;
    }

    public void setProductPackageForm(ProductPackageForm productPackageForm) {
        this.productPackageForm = productPackageForm;
    }

    public RedirectUrls getRedirectUrls() {
        return redirectUrls;
    }

    public void setRedirectUrls(RedirectUrls redirectUrls) {
        this.redirectUrls = redirectUrls;
    }
}
