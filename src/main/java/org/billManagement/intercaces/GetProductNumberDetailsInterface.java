package org.billManagement.intercaces;

import org.billManagement.models.dao.Orders;
import org.billManagement.models.dto.ProductNumberDetailsDto;

import java.util.ArrayList;
@FunctionalInterface
public interface GetProductNumberDetailsInterface {

    ArrayList<ProductNumberDetailsDto> getProductNumberDetails();
}
