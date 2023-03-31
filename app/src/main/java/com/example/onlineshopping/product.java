package com.example.onlineshopping;

import android.media.Image;

public class product {
    String productName, productPrice,productImage;


    public product(String productName, String productPrice, Image productImage) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productImage = String.valueOf(productImage);
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(Image productImage) {
        this.productImage = String.valueOf(productImage);
    }
}
