package org.billManagement.models.dto;

public class ProductNumberDetailsDto {
    private int productNumber;
    private int orderId;
    private int totalPieces;

    public ProductNumberDetailsDto(int productNumber, int orderId, int totalPieces) {
        this.productNumber = productNumber;
        this.orderId = orderId;
        this.totalPieces = totalPieces;
    }

    @Override
    public String toString() {
        return "ProductNumberDetailsDto{" +
                "productNumber=" + productNumber +
                ", orderId=" + orderId +
                ", totalPieces=" + totalPieces +
                '}';
    }
}
