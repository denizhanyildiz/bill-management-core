package org.billManagement.models.dto;

public class OrderInfoDto {
    private int orderId;
    private int productNumber;
    private double averagePrice;

    public OrderInfoDto(int orderId, int productNumber, double averagePrice) {
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

    @Override
    public String toString() {
        return "OrderInfoDto{" +
                "orderId=" + orderId +
                ", productNumber=" + productNumber +
                ", averagePrice=" + averagePrice +
                '}';
    }
}
