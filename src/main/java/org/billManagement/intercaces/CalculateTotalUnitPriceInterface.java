package org.billManagement.intercaces;

import org.billManagement.models.dao.Orders;

import java.util.ArrayList;

@FunctionalInterface
public interface CalculateTotalUnitPriceInterface {
    Double calculateTotalUnitPrice();
}
