package org.billManagement.models.dto;

import org.billManagement.models.dao.Orders;

public class OrderDto {

    private int id;
    private Integer orderId;
    private Integer productNumber;
    private Integer piece;
    private String unitPrice;

    public Orders orderDtoToOrder(OrderDto orderDto) {
        Orders orders = new Orders();
        orders.setId(orderDto.getId());
        orders.setOrderId(orderDto.getOrderId());
        orders.setPiece(orderDto.getPiece());
        orders.setUnitPrice(orderDto.getUnitPrice());
        orders.setProductNumber(orderDto.getProductNumber());
        return orders;
    }

    public OrderDto orderToOrderDto(Orders orders) {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(orders.getId());
        orderDto.setPiece(orders.getPiece());
        orderDto.setUnitPrice(orders.getUnitPrice());
        orderDto.setOrderId(orders.getOrderId());
        orderDto.setProductNumber(orders.getProductNumber());
        return orderDto;
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
