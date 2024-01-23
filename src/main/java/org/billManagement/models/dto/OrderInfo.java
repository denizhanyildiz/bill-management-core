package org.billManagement.models.dto;

public class OrderInfo {
    private int orderId;
    private int productNumber;
    private double averagePrice;

    public OrderInfo(int orderId, int productNumber, double averagePrice) {
        this.orderId = orderId;
        this.productNumber = productNumber;
        this.averagePrice = averagePrice;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getProductNumber() {
        return productNumber;
    }

    public double getAveragePrice() {
        return averagePrice;
    }
}
