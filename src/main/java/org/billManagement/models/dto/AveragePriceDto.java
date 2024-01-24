package org.billManagement.models.dto;

public class AveragePriceDto {
    private Integer productNumber;
    private String unitPrice;

    public AveragePriceDto(Integer productNumber, String unitPrice) {
        this.productNumber = productNumber;
        this.unitPrice = unitPrice;
    }

    public Integer getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(Integer productNumber) {
        this.productNumber = productNumber;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "AveragePriceDto{" +
                "productNumber=" + productNumber +
                ", unitPrice='" + unitPrice + '\'' +
                '}';
    }
}
