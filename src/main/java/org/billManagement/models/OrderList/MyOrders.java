package org.billManagement.models.OrderList;

import org.billManagement.models.dao.Orders;

import java.util.ArrayList;

public class MyOrders {

    private ArrayList<Orders> ordersArrayList;


    public MyOrders(ArrayList<Orders> ordersArrayList) {
        this.ordersArrayList = ordersArrayList;
    }

    public MyOrders() {
    }

    public ArrayList<Orders> getOrdersArrayList() {
        return ordersArrayList;
    }
}
