package org.billManagement.intercaces;

import org.billManagement.models.dao.Orders;
import org.billManagement.models.dto.AveragePriceDto;

import java.util.ArrayList;
@FunctionalInterface
public interface FindAveragePriceByProductNumberInterface {

    ArrayList<AveragePriceDto> findAveragePriceByProductNumber();
}
