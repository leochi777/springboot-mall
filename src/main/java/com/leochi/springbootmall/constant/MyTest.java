package com.leochi.springbootmall.constant;

public class MyTest {
    public static void main(String[] args) {
        ProductCategory productCategory=ProductCategory.FOOD;
        String s= productCategory.name();
        System.out.println(s);
        String s2="CAR";
        //if true 存 s2 into category
        ProductCategory category=ProductCategory.valueOf(s2);

    }
}
