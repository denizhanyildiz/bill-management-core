package org.billManagement.service;

import org.billManagement.intercaces.*;
import org.billManagement.models.dao.Orders;
import org.billManagement.models.dto.*;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class OrdersService implements CalculateAveragePriceByOrderIdAndProductNumberInterface,
        CalculateTotalUnitPriceInterface,
        FindAveragePriceByProductNumberInterface,
        GetAllOrderInterface,
        GetProductNumberDetailsInterface {

    private MyOrders myOrders;

    public OrdersService(MyOrders myOrders) {
        this.myOrders = myOrders;
    }

    /**
     * Bu Metot 1. soru a maddesine cevap vermek amacıyla yazılmıtır.
     *
     * @return
     */
    @Override
    public Double calculateTotalUnitPrice() {
        return myOrders.getOrdersArrayList().stream()
                .mapToDouble(order -> Double.parseDouble(order.getUnitPrice()) * order.getPiece())
                .sum();
    }

    /**
     * Bu API 1. soru c maddesine cevap vermek amacıyla yazılmıştır.
     *
     * @return
     */
    @Override
    public ArrayList<OrderInfoDto> calculateAveragePriceByOrderIdAndProductNumber() {
        return myOrders.getOrdersArrayList().stream()
                .collect(Collectors.groupingBy(
                        Orders::getOrderId,
                        Collectors.groupingBy(
                                Orders::getProductNumber,
                                Collectors.averagingDouble(order -> Double.parseDouble(order.getUnitPrice()))
                        )
                ))
                .entrySet().stream()
                .flatMap(orderEntry ->
                        orderEntry.getValue().entrySet().stream()
                                .map(productEntry -> new OrderInfoDto(
                                        orderEntry.getKey(),
                                        productEntry.getKey(),
                                        productEntry.getValue())))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Bu API 1. soru b maddesine cevap vermek amacıyla yazılmıştır.
     *
     * @return
     */
    @Override
    public ArrayList<AveragePriceDto> findAveragePriceByProductNumber() {
        return myOrders.getOrdersArrayList().stream()
                .collect(Collectors.groupingBy(
                        Orders::getProductNumber,
                        Collectors.averagingDouble(order -> Double.parseDouble(order.getUnitPrice()))
                ))
                .entrySet().stream()
                .map(entry -> new AveragePriceDto(entry.getKey(), String.valueOf(entry.getValue())))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Bu metot 2. soruya cevap vermek amacıyla yazılmıştır.
     *
     * @return
     */
    @Override
    public ArrayList<OrderDto> getAllOrder() {
        return myOrders.getOrdersArrayList().stream()
                .map(eachOrders -> {
                    OrderDto orderDto = new OrderDto();
                    orderDto.setOrderId(eachOrders.getId());
                    orderDto.setPiece(eachOrders.getPiece());
                    orderDto.setUnitPrice(eachOrders.getUnitPrice());
                    orderDto.setProductNumber(eachOrders.getProductNumber());
                    return orderDto;
                })
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Bu API 1. soru d maddesine cevap vermek amacıyla yazılmıştır.
     *
     * @return
     */
    @Override
    public ArrayList<ProductNumberDetailsDto> getProductNumberDetails() {
        return myOrders.getOrdersArrayList().stream()
                .collect(Collectors.groupingBy(
                        Orders::getProductNumber,
                        Collectors.groupingBy(
                                Orders::getOrderId,
                                Collectors.summingInt(Orders::getPiece)
                        )
                ))
                .entrySet().stream()
                .flatMap(entry ->
                        entry.getValue().entrySet().stream()
                                .map(innerEntry -> new ProductNumberDetailsDto(
                                        entry.getKey(),
                                        innerEntry.getKey(),
                                        innerEntry.getValue()
                                ))
                )
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
