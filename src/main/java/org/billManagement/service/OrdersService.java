package org.billManagement.service;

import org.billManagement.models.OrderList.MyOrders;
import org.billManagement.models.dao.Orders;
import org.billManagement.models.dto.OrderDto;
import org.billManagement.models.dto.OrderInfo;
import org.billManagement.models.dto.ProductNumberDetails;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrdersService {

    /**
     * Bu API 1. soru a maddesine cevap vermek amacıyla yazılmıtır.
     *
     * @return
     */
    public static Double calculateTotalUnitPrice(ArrayList<Orders> orders) {
        ArrayList<Orders> ordersArrayList = orders;

        Double totalUnitPrice = ordersArrayList.stream()
                .mapToDouble(order -> Double.parseDouble(order.getUnitPrice()) * order.getPiece())
                .sum();

        return totalUnitPrice;
    }

    /**
     * Bu API 1. soru b maddesine cevap vermek amacıyla yazılmıştır.
     *
     * @return
     */
    public static ArrayList<Orders> findAveragePriceByProductNumber(ArrayList<Orders> orders) {
        Map<Integer, Double> averagePricesByProductNumber = orders.stream()
                .collect(Collectors.groupingBy(
                        Orders::getProductNumber,
                        Collectors.averagingDouble(order -> Double.parseDouble(order.getUnitPrice()))
                ));

        ArrayList<Orders> ordersList = new ArrayList<>();

        averagePricesByProductNumber.forEach((productNumber, averagePrice) -> {
            Orders order = new Orders(productNumber, String.valueOf(averagePrice));
            ordersList.add(order);
        });

        return ordersList;
    }

    /**
     * Bu API 1. soru c maddesine cevap vermek amacıyla yazılmıştır.
     *
     * @return
     */
    public static ArrayList<OrderInfo> calculateAveragePriceByOrderIdAndProductNumber(ArrayList<Orders> orders) {
        return orders.stream()
                .collect(Collectors.groupingBy(
                        Orders::getOrderId,
                        Collectors.groupingBy(
                                Orders::getProductNumber,
                                Collectors.averagingDouble(order -> Double.parseDouble(order.getUnitPrice()))
                        )
                ))
                .entrySet().stream()
                .flatMap(orderEntry -> orderEntry.getValue().entrySet().stream()
                        .map(productEntry -> new OrderInfo(
                                orderEntry.getKey(),
                                productEntry.getKey(),
                                productEntry.getValue())))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Bu API 1. soru d maddesine cevap vermek amacıyla yazılmıştır.
     *
     * @return
     */
    public static ArrayList<ProductNumberDetails> getProductNumberDetails(ArrayList<Orders> orders) {
        ArrayList<Orders> ordersArrayList = orders;

        ArrayList<ProductNumberDetails> productNumberDetailsList = ordersArrayList.stream()
                .collect(Collectors.groupingBy(Orders::getProductNumber,
                        Collectors.groupingBy(Orders::getOrderId,
                                Collectors.summingInt(Orders::getPiece))))
                .entrySet().stream()
                .flatMap(entry -> entry.getValue().entrySet().stream()
                        .map(innerEntry -> new ProductNumberDetails(entry.getKey(), innerEntry.getKey(), innerEntry.getValue())))
                .collect(Collectors.toCollection(ArrayList::new));

        return productNumberDetailsList;
    }

    /**
     * Bu metot 2. soruya cevap vermek amacıyla yazılmıştır.
     *
     * @return
     */
    public static ArrayList<OrderDto> getAllOrder(ArrayList<Orders> orders) {
        ArrayList<OrderDto> orderDtoList = new ArrayList<>();
        for (Orders eachOrders : orders) {
            OrderDto orderDto = new OrderDto();
            orderDto.setOrderId(eachOrders.getId());
            orderDto.setPiece(eachOrders.getPiece());
            orderDto.setUnitPrice(eachOrders.getUnitPrice());
            orderDto.setProductNumber(eachOrders.getProductNumber());
            orderDtoList.add(orderDto);
        }
        return orderDtoList;
    }

}
