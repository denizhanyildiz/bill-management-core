package org.billManagement;

import org.billManagement.models.dao.Orders;
import org.billManagement.models.dto.MyOrders;
import org.billManagement.service.OrdersService;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Orders> ordersArrayList = new ArrayList<>();
        ordersArrayList.add(new Orders(1, 1000, 2000, 12, "100.51"));
        ordersArrayList.add(new Orders(2, 1000, 2001, 31, "200"));
        ordersArrayList.add(new Orders(3, 1000, 2002, 22, "150.86"));
        ordersArrayList.add(new Orders(4, 1000, 2003, 41, "250"));
        ordersArrayList.add(new Orders(5, 1000, 2004, 55, "244"));
        ordersArrayList.add(new Orders(6, 1001, 2001, 88, "44.531"));
        ordersArrayList.add(new Orders(7, 1001, 2002, 121, "88.11"));
        ordersArrayList.add(new Orders(8, 1001, 2004, 74, "211"));
        ordersArrayList.add(new Orders(9, 1001, 2002, 14, "88.11"));
        ordersArrayList.add(new Orders(10, 1002, 2003, 2, "12.1"));
        ordersArrayList.add(new Orders(11, 1002, 2004, 3, "22.3"));
        ordersArrayList.add(new Orders(12, 1002, 2003, 8, "12.1"));
        ordersArrayList.add(new Orders(13, 1002, 2002, 16, "94"));
        ordersArrayList.add(new Orders(14, 1002, 2005, 9, "44.1"));
        ordersArrayList.add(new Orders(15, 1002, 2006, 19, "90"));

        MyOrders myOrders = new MyOrders(ordersArrayList);

        OrdersService.calculateTotalUnitPrice(myOrders.getOrdersArrayList());
        OrdersService.findAveragePriceByProductNumber(myOrders.getOrdersArrayList());
        OrdersService.calculateAveragePriceByOrderIdAndProductNumber(myOrders.getOrdersArrayList());
        OrdersService.getProductNumberDetails(myOrders.getOrdersArrayList());
        OrdersService.getAllOrder(myOrders.getOrdersArrayList());

    }

}