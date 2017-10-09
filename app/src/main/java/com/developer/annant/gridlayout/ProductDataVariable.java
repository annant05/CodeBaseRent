package com.developer.annant.gridlayout;

/**
 * Created by Annant on 28-04-2017.
 */

public class ProductDataVariable {

    private String productName;
    private int debitRs;
    private int rentRs;
    private int thumbImageResourceId;


    public ProductDataVariable(String productName, int debitRs, int rentRs, int thumbImageResourceId) {
        this.productName = productName;
        this.debitRs = debitRs;
        this.rentRs = rentRs;
        this.thumbImageResourceId = thumbImageResourceId;

    }

    public String getProductName() {
        return this.productName;
    }

    public int getDebitRs() {
        return this.debitRs;
    }

    public int getRentRs() {
        return this.rentRs;
    }

    public int getThumbImageResourceId() {
        return this.thumbImageResourceId;
    }

}
