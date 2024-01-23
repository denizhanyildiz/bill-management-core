package org.billManagement.models.dao;

public class Orders {

    private int id;
    private Integer orderId;
    private Integer productNumber;
    private Integer piece;
    private String unitPrice;

    public Orders() {
    }

    public Orders(Integer productNumber, String unitPrice) {
        this.productNumber = productNumber;
        this.unitPrice = unitPrice;
    }

    public Orders(int id, Integer orderId, Integer productNumber, Integer piece, String unitPrice) {
        this.id = id;
        this.orderId = orderId;
        this.productNumber = productNumber;
        this.piece = piece;
        this.unitPrice = unitPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(Integer productNumber) {
        this.productNumber = productNumber;
    }

    public Integer getPiece() {
        return piece;
    }

    public void setPiece(Integer piece) {
        this.piece = piece;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }
}
