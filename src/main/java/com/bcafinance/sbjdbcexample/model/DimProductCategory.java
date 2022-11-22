package com.bcafinance.sbjdbcexample.model;
/*
Created By IntelliJ IDEA 2022.2.3 (Community Edition) 
@Author ASUS a.k.a. Archan
ITDP 7
Created on 22/11/2022
@Last Modified on 22/11/2022 12:01
Version 1.0
*/

public class DimProductCategory {

    private int ProductCategoryKey;
    private int productCategoryAlternateKey;
    private String englishProductCategoryName;
    private String spanishProductCategoryName;
    private String frenchProductCategoryName;

    public DimProductCategory() {
    }

    public DimProductCategory(int productCategoryAlternateKey, String englishProductCategoryName, String spanishProductCategoryName, String frenchProductCategoryName) {
        this.productCategoryAlternateKey = productCategoryAlternateKey;
        this.englishProductCategoryName = englishProductCategoryName;
        this.spanishProductCategoryName = spanishProductCategoryName;
        this.frenchProductCategoryName = frenchProductCategoryName;
    }

    public int getProductCategoryKey() {
        return ProductCategoryKey;
    }

    public void setProductCategoryKey(int productCategoryKey) {
        ProductCategoryKey = productCategoryKey;
    }
    public int getProductCategoryAlternateKey() {
        return productCategoryAlternateKey;
    }

    public void setProductCategoryAlternateKey(int productCategoryAlternateKey) {
        this.productCategoryAlternateKey = productCategoryAlternateKey;
    }

    public String getEnglishProductCategoryName() {
        return englishProductCategoryName;
    }

    public void setEnglishProductCategoryName(String englishProductCategoryName) {
        this.englishProductCategoryName = englishProductCategoryName;
    }

    public String getSpanishProductCategoryName() {
        return spanishProductCategoryName;
    }

    public void setSpanishProductCategoryName(String spanishProductCategoryName) {
        this.spanishProductCategoryName = spanishProductCategoryName;
    }

    public String getFrenchProductCategoryName() {
        return frenchProductCategoryName;
    }

    public void setFrenchProductCategoryName(String frenchProductCategoryName) {
        this.frenchProductCategoryName = frenchProductCategoryName;
    }

}
