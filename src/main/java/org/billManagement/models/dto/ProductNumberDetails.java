package org.billManagement.models.dto;

public class ProductNumberDetails {
    private int productNumber;
    private int orderId;
    private int totalPieces;

    public ProductNumberDetails(int productNumber, int orderId, int totalPieces) {
        this.productNumber = productNumber;
        this.orderId = orderId;
        this.totalPieces = totalPieces;
    }

    // Getters and setters (if needed)

    @Override
    public String toString() {
        return "ProductNumberDetails{" +
                "productNumber=" + productNumber +
                ", orderId=" + orderId +
                ", totalPieces=" + totalPieces +
                '}';
    }
}
