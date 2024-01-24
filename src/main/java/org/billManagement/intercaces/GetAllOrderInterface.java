package org.billManagement.intercaces;

import org.billManagement.models.dao.Orders;
import org.billManagement.models.dto.OrderDto;

import java.util.ArrayList;
@FunctionalInterface
public interface GetAllOrderInterface {
    ArrayList<OrderDto> getAllOrder();
}
