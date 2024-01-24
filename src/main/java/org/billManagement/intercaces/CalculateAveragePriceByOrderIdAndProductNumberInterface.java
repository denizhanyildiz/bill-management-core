package org.billManagement.intercaces;

import org.billManagement.models.dao.Orders;
import org.billManagement.models.dto.OrderInfoDto;

import java.util.ArrayList;
@FunctionalInterface
public interface CalculateAveragePriceByOrderIdAndProductNumberInterface {

    ArrayList<OrderInfoDto> calculateAveragePriceByOrderIdAndProductNumber();
}
